package ex1;
/*
@luizASSilveira
*/

import java.util.Random;

public class Consumidor extends Thread{
    private Monitor monitor;
    private Integer number;

    public Consumidor(Monitor monitor) {
        Random number = new Random();
        this.number = number.nextInt(4000);
        this.monitor = monitor;
    }
    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(this.number);
                System.out.println("consumidor: " + this.getId());
                System.out.println( "mensagem: " + this.monitor.take() );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
