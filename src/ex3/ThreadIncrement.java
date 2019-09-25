package ex3;

/**
 * @author luizASSilveira
 */

import java.util.Random;

public class ThreadIncrement extends Thread {
    BoundedCounter monitor;
    public ThreadIncrement(BoundedCounter monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Random num = new Random();

        while (true){
            try {
                Thread.sleep(num.nextInt(2000));
                monitor.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
