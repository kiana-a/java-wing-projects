/**
 * Created by kiana on 11/8/17.
 */
public class Buffer {
    private char grass;
    private volatile boolean bushAble = true;


    synchronized void setGrass(char grass){
        while (!bushAble){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.grass = grass;
        bushAble = false;
        notify();
    }

    synchronized char getGrass(){
        while (bushAble)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bushAble = true;
        notify();
        return this.grass;
    }
}
