package ex1;
/*
Implemente uma solução com monitor para o problema do Produtor-Consumidor usando um buffer circular.

@luizASSilveira
*/

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(5);

        Thread m1 = new Thread( new Consumidor( monitor ) );
        Thread m2 = new Thread( new Consumidor( monitor ) );
        Thread m3 = new Thread( new Consumidor( monitor ) );
        Thread m4 = new Thread( new Consumidor( monitor ) );

        Thread p1 = new Thread( new Publicador( monitor ) );
        Thread p2 = new Thread( new Publicador( monitor ) );
        Thread p3 = new Thread( new Publicador( monitor ) );
        Thread p4 = new Thread( new Publicador( monitor ) );

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        m1.start();
        m2.start();
        m3.start();
        m4.start();

    }
}
