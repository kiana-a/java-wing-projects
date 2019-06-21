import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by kiana on 11/23/17.
 */
public class Application {
    private static InetAddress host;
    private static final int PORT = 8080;

    public static void main(String[] args)
    {
        try
        {
            host = InetAddress.getByName("127.0.0.1");
        }
        catch(UnknownHostException uhEx)
        {
            System.out.println("Host ID not found");
            System.exit(1);
        }
        accessServer();

    }
    private static void accessServer()
    {
        Socket link = null;
        try
        {
            link = new Socket(host,PORT);
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);

            Scanner userEntry = new Scanner(System.in);
            String message,response;
            do
            {
                System.out.print("Enter Message : ");
                message = userEntry.nextLine();
                output.println(message);
                response = input.nextLine();
                System.out.println("\n<Server> : " + response);
            }while(!message.equals("QUIT"));
        }
        catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
        finally
        {
            try
            {
                System.out.println("\n* Closing connection *");
                link.close();
            }
            catch(IOException ioEx)
            {
                System.out.println(
                        "Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}
