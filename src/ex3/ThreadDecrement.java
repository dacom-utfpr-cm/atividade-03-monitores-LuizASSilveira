package ex3;
/**
 * @author luizASSilveira
 */
import java.util.Random;

public class ThreadDecrement extends Thread{
    BoundedCounter monitor;

    public ThreadDecrement(BoundedCounter monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Random num = new Random();

        while (true){
            try {
                Thread.sleep(num.nextInt(2000));
                monitor.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
