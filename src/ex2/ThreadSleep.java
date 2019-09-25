package ex2;

import java.util.Random;

public class ThreadSleep extends Thread{
    Monitor monitor;

    public ThreadSleep(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        Random number = new Random();
        int valAleatorio = number.nextInt(100);
        System.out.println("valor aleatorio: " + valAleatorio);
        int valor = monitor.sleepUntil(valAleatorio);
        System.out.println("Thread: " + this.getId() + " acordou no cout: " + valor);
    }
}
