import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by kiana on 12/7/17.
 */
public class Application {
    private static InetAddress host;
    private static int PORT = 8080;

    public static volatile String name;


    public static void main(String[] args) throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Ip");
            String Ip = scanner.nextLine();
            System.out.println("Enter Port");
            Integer Port = scanner.nextInt();
            host = InetAddress.getByName(Ip);
            PORT = Port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        accessServer();
    }

    private static void accessServer() throws IOException {
        Socket link = null;
        try {
            link = new Socket(host, PORT);
            Thread sender = new Thread(new Send(link));
            Thread receiver = new Thread(new Receive(link));
            sender.start();
            receiver.start();
            try {
                sender.join();
                receiver.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                System.out.println("\nclose the connection\n");
                link.close();
            } catch (IOException ioEx) {
                System.out.println("unable to disconnect");
                System.exit(1);
            }
        }
    }
}
