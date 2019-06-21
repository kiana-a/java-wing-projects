package run.wing.io.sample;

import java.io.*;
import java.util.Scanner;

/**
 * Created by kiana on 10/19/17.
 */
public class Application {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        int a = scanner.nextInt();
//
//        System.out.println("Input : " + input + " "  + a);

//        try {
//            FileInputStream fileInputStream = new FileInputStream("data.txt");
//            FileOutputStream fileOutputStream = new FileOutputStream("data2.txt");
//
//            int stream;
//
//            while ((stream = fileInputStream.read()) != -1){
//                System.out.println((char) stream);
//                fileOutputStream.write(stream);
//            }
//            fileOutputStream.flush();
//            fileOutputStream.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            FileReader fileReader = new FileReader("data.txt");
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            FileWriter fileWriter = new FileWriter("data3.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
////            int stream;
////            while ((stream = fileReader.read()) != -1){
////                System.out.println((char) stream);
////            }
//
//            String input;
//            while ((input = bufferedReader.readLine()) != null) {
//                System.out.println(input);
//                bufferedWriter.write(input);
//                bufferedWriter.newLine();
//            }
//            bufferedWriter.flush();
//            bufferedWriter.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        File file = new File("data.txt");
        try {
            Scanner scanner = new Scanner(file);
            PrintWriter printWriter = new PrintWriter("data4.txt");
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                s.split(" ");
                printWriter.write(s);
                printWriter.println();
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String نام="کیانا";
        چاپکن(نام);
    }

    private static void چاپکن(String ورودی) {
        System.out.println(ورودی);
    }

}
