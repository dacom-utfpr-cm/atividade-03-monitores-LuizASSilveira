package ex2;

import java.util.Random;

public class ThreadCount extends Thread{

    Monitor monitor;

    public ThreadCount(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Random nunber = new Random();
        while (true){

            try {
                Thread.sleep(nunber.nextInt(1000));
                monitor.increment();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
