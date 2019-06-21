import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kiana on 11/23/17.
 */


public class Application {

    private static ServerSocket serverSocket;
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(PORT,0,InetAddress.getByName("127.0.0.1"));
        } catch (IOException ioEx) {
            System.out.println("\nUnable to set up port!");
            System.exit(1);
        }

        do {
            Socket client = serverSocket.accept();
            System.out.println("\nNew client accepted.\n");
            ClientHandler handler = new ClientHandler(client);
            handler.start();
        } while (true);
    }
}

class ClientHandler extends Thread {
    private Socket client;
    private Scanner input;
    private PrintWriter output;

    public ClientHandler(Socket socket) {
        client = socket;
        try {
            input = new Scanner(client.getInputStream());
            output = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }

    public void run() {
        String received;
        do {
            received = input.nextLine();
            output.println("ECHO: " + received + " Khob");
        } while (!received.equals("QUIT"));

        try {
            if (client != null) {
                System.out.println(
                        "Closing down connection...");
                client.close();
            }
        } catch (IOException ioEx) {
            System.out.println("Unable to disconnect!");
        }
    }
}
