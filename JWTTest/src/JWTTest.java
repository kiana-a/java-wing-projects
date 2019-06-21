import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * Created by kiana on 1/21/18.
 */
public class JWTTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        User user = new User("kiana","ahmadi");

//        Scanner scanner = new Scanner(System.in);
//        user.setName(scanner.nextLine());
//        user.setFname(scanner.nextLine());

        Algorithm algorithm = Algorithm.HMAC256("7ybv35y89y95y93yjv;OJSLHGS");
//        String token = JWT.create()
//                .withClaim("name","kiana")
//                .withIssuer("auth0").sign(algorithm);

        String token1 = JWT.create()
                .withClaim("name",user.getName())
                .withIssuer("auth0")
                .sign(algorithm);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build(); //Reusable verifier instance

        System.out.println(token1);

        DecodedJWT jwt = verifier.verify(token1);

        System.out.println(jwt.getClaim("name").as(String.class));
    }
}
