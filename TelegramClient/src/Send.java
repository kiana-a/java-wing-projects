import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kiana on 12/7/17.
 */
public class Send implements Runnable {
    private Socket socket;
    private PrintWriter printWriter;

    public Send(Socket socket) {
        this.socket = socket;
        try {
            printWriter = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Message message = new Message();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Menu : " +
                    "\n1.Register" +
                    "\n2.Send message"
            );
            Integer choice = scanner.nextInt();

            scanner.nextLine();

            if (choice == 1){
                System.out.println("\nEnter your name:");
                message.setBody(scanner.nextLine());
                message.setAction("register");
            }
            else if(choice == 2){
                System.out.println("\nwho you wanna send message to?");
                message.setReceiver(scanner.nextLine());
                message.setSender(Application.name);
                System.out.println("\nput your message");
                message.setBody(scanner.nextLine());
                message.setAction("message");
            }
            else{
                System.out.println("\nWrong choice!!");
                continue;
            }
            printWriter.println(new Gson().toJson(message));

        }while (!message.getBody().equals("Quit"));
    }
}
