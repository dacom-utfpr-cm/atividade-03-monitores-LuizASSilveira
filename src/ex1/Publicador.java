package ex1;
/*  @luizASSilveira   */

import java.util.Random;

public class Publicador extends Thread{
    private Integer number;
    private Monitor monitor;

    public Publicador(Monitor monitor) {
        Random number = new Random();
        this.number = number.nextInt(4000);
        this.monitor = monitor;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(this.number);
                this.monitor.put("Posição lida: " + this.monitor.getPosition() +  "-->  Menssagem escrita pelo Publicador : " + this.getId() );

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
