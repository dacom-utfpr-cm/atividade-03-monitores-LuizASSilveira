package ex2;
/**
 * Escreva uma monitor Counter que possibilita um processo dormir até o contador alcançar um valor.
 * A classe Counter permite duas operações: increment() e sleepUntil(int x).
 * @author luizASSilveira
 * ***/

public class main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();

        Thread t1 = new Thread(new ThreadCount(monitor));
        Thread t5 = new Thread(new ThreadCount(monitor));
        Thread t6 = new Thread(new ThreadCount(monitor));



        Thread t2 = new Thread(new ThreadSleep(monitor));
        Thread t3 = new Thread(new ThreadSleep(monitor));
        Thread t4 = new Thread(new ThreadSleep(monitor));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}
