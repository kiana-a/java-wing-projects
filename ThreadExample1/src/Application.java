import java.util.concurrent.Semaphore;

/**
 * Created by kiana on 11/7/17.
 */
public class Application {

    private volatile static int result = 0;


//    public static void main(String[] args) throws InterruptedException {
////        Runnable runnable1 = new Runnable() {
////            public void getResult(String name){
////                System.out.println(name + " " + (++result));
////            }
////
////            @Override
////            public void run() {
////                synchronized (this){
////                    getResult(Thread.currentThread().getName());
////                }
////            }
////        };
////
//////        Runnable runnable2 = () -> {
//////            getResult("Thread2");
//////        };
//
//        Buffer daneshjooPark = new Buffer();
//        Producer producer = new Producer(daneshjooPark);
//        Consumer consumer = new Consumer(daneshjooPark);
//
//        Thread thread1 = new Thread(producer);
//        Thread thread2 = new Thread(consumer);
//
//        thread1.start();
//        thread2.start();
//
//        //getResult("default Thread");
//
////        MathOperator addOperator = (a,b) ->  a + b ;
////        MathOperator subOperator = (a,b) -> a - b;
////
////        System.out.println(subOperator.operate(3,6));
//    }
    private static Gate gate1 = new Gate(1);
    private static Gate gate2 = new Gate(0);
    private static Gate gate3 = new Gate(0);


    private static Gate gate4 = new Gate(5);

    private static Semaphore semaphore = new Semaphore(5);
    public static void main(String[] args) {

        Runnable mohammad = new Runnable() {
            @Override
            public void run() {
                for (int i = 10 ; i > 0 ; i--){
                    gate1.getIn();
                    System.out.println("Mohammad");
                    gate2.getOut();
                }
            }
        };
        Runnable kiana = new Runnable() {
            @Override
            public void run() {
                for (int i = 10 ; i > 0 ; i--){
                    gate2.getIn();
                    System.out.println("Kiana");
                    gate3.getOut();
                }
            }
        };
        Runnable Ali = new Runnable() {
            @Override
            public void run() {
                for (int i = 10 ; i > 0 ; i--){
                    gate3.getIn();
                    System.out.println("Ali");
                    gate1.getOut();
                }
            }
        };


        Runnable print = new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 10 ; i > 0 ; i--){
                    System.out.println(Thread.currentThread().getName() + " " +  i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                semaphore.release();
            }
        };



        for (int i = 0; i < 20 ; i++){
            new Thread(print,"Thread " + i).start();
        }


//        Thread thread1 = new Thread(mohammad);
//        Thread thread2 = new Thread(kiana);
//        Thread thread3 = new Thread(Ali);
//        thread1.start();
//        thread2.start();
//        thread3.start();


    }
}
