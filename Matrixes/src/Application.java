import java.util.*;

/**
 * Created by kiana on 11/19/17.
 */
public class Application {

    private static volatile int[][] matrix1;
    private static volatile int[][] matrix2;
    private static volatile int[][] matrix3;


    public static List<Bound> getBounds(int rowNums,int threadNums){
        int start = 0;
        int end = 0;
        List<Bound> bounds = new ArrayList<>();
        int length = rowNums / threadNums;
        if( length >= 1)
        {
            for (int i = 0 ; i < threadNums ; i++){
                end += length;
                bounds.add(new Bound(start,((i<threadNums -1)? end : (end+rowNums%threadNums))));
                start = end;
            }
        }
        return bounds;
    }


    public static void init(int[][] matrix){

        Random random = new Random();
        for (int i = 0 ; i<matrix.length ; i++){
            for (int j = 0 ; j < matrix[0].length ; j++){
                matrix[i][j] = random.nextInt(10);
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        matrix1 = new int[Integer.valueOf(args[0])][Integer.valueOf(args[1])];
        matrix2 = new int[Integer.valueOf(args[1])][Integer.valueOf(args[2])];
        matrix3 = new int[Integer.valueOf(args[0])][Integer.valueOf(args[2])];
        init(matrix1);
        init(matrix2);


        Date start,end;

        List<Bound> bounds = getBounds(Integer.valueOf(args[0]),Integer.valueOf(args[3]));


        start = new Date();
        List<Thread> threadList = new ArrayList<>();
        for (Bound bound: bounds){
            Thread thread = new Thread(new Matrix(matrix1,matrix2,matrix3,bound));
            System.out.println("Thread Create , Bound : " + bound.getStart() + " "+ bound.getEnd());
            thread.start();
            threadList.add(thread);
        }

        for (Thread thread : threadList)
            thread.join();

        end = new Date();


        System.out.println("ExecutionTime : " + (end.getTime() - start.getTime()));



    }


}