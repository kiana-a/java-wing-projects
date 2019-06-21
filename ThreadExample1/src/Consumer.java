/**
 * Created by kiana on 11/8/17.
 */
public class Consumer implements Runnable {

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        char c;
        do {
            c = buffer.getGrass();
            System.out.println("Consumed : " + c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (c != 'x');
    }
}
