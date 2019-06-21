import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Handler;

/**
 * Created by kiana on 12/5/17.
 */

public class Application {
    private static ServerSocket serverSocket;
    private static final int PORT = 8080;


    public static volatile Map<String, PrintWriter> printWriterMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        try {
            serverSocket = new ServerSocket(PORT, 0, InetAddress.getByName("192.168.121.215"));
        } catch (IOException e) {
            e.printStackT
            race();
        }

        do {
            Socket client = serverSocket.accept();
            System.out.println("Client accepted. \n");
            ClientHandler handler = new ClientHandler(client);
            handler.start();

        } while (true);

    }

    static class ClientHandler extends Thread {
        private Socket client;
        private Scanner input;
        private PrintWriter output;

        public ClientHandler(Socket socket) {
            client = socket;
            try {
                input = new Scanner(client.getInputStream());
                output = new PrintWriter(client.getOutputStream(),true);     //chera true neveshte shde bud?
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            Message message;
            Message outputMessage = new Message();
            do {

                String inputStr = input.nextLine();
                message = new Gson().fromJson(inputStr, Message.class);

                if (message.getAction().equals("register")) {
                    if (printWriterMap.containsKey(message.getBody()) || message.getBody().equals("server")) {
                        outputMessage.setAction("print");
                        outputMessage.setBody("Register Not Complete");
                        outputMessage.setStatus(403);
                        outputMessage.setSender("server");
                    } else {
                        printWriterMap.put(message.getBody(), output);
                        outputMessage.setAction("print");
                        outputMessage.setBody("This user is registered ");
                        outputMessage.setStatus(1000);
                        outputMessage.setReceiver(message.getBody());
                        outputMessage.setSender("server");
                    }
                    output.println(new Gson().toJson(outputMessage));
                } else if (message.getAction().equals("message")) {
                    if (printWriterMap.containsKey(message.getReceiver())) {
                        PrintWriter receiverPrintWriter = printWriterMap.get(message.getReceiver());
                        message.setAction("print");
                        message.setStatus(200);
                        receiverPrintWriter.println(new Gson().toJson(message));
                    } else {
                        outputMessage.setAction("print");
                        outputMessage.setBody("user not found ");
                        outputMessage.setStatus(404);
                        outputMessage.setSender("server");
                        output.println(new Gson().toJson(outputMessage));
                    }

                } else {
                    outputMessage.setAction("print");
                    outputMessage.setBody("Bad Action : Forbbiden");
                    outputMessage.setStatus(403);
                    outputMessage.setSender("server");
                    output.println(new Gson().toJson(outputMessage));
                }

            } while (!message.getBody().equals("Quit"));
        }
    }
}

