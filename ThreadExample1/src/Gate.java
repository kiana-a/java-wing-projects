/**
 * Created by kiana on 11/18/17.
 */
public class Gate {
    private int capacity;

    public Gate(Integer capacity) {
        this.capacity = capacity;
    }

    synchronized void getIn() {
        while (capacity == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        capacity--;
    }
    synchronized void getOut() {
        capacity++;
        notify();
    }
}



