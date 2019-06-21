import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kiana on 12/7/17.
 */
public class Receive implements Runnable {
    private Socket socket;
    private Scanner scanner;

    public Receive(Socket socket) {
        this.socket = socket;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Message message ;
        do {
            String input = scanner.nextLine();
            message = new Gson().fromJson(input,Message.class);

            if(message.getAction().equals("print")){
                System.out.println(message.getSender()+":  " + message.getBody());
            }
            if (message.getStatus() == 1000) {
                Application.name = message.getReceiver();
            }
        }while(!message.getBody().equals("Quit"));

    }
}
