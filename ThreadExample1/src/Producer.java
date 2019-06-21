/**
 * Created by kiana on 11/8/17.
 */
public class Producer implements Runnable {

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (char c = 'a'; c != 'z'; c++) {
            buffer.setGrass(c);
            System.out.println("Produced : " + c);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
