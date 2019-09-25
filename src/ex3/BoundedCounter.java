package ex3;

/**
 * @author luizASSilveira
 */

import java.util.Random;

public class BoundedCounter {
    private int count = 50;
    private int limitInferior = 0;
    private int limitSuperior = 100;
    private boolean empty = false;


    public synchronized void increment(){
        while ( this.empty ) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.empty = true;
        Random num = new Random();
        int numAux = num.nextInt(50);

        if ((numAux + this.count) > limitSuperior){
            try{
                this.empty = false;
                notifyAll();
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            this.count += numAux;
            System.out.println("Increment: " + numAux);
            System.out.println("Valor atual " + this.count);
        }
        this.empty = false;
        notifyAll();
    }

    public synchronized void decrement(){
        while ( this.empty ) {
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.empty = true;
        Random num = new Random();
        int numAux = num.nextInt(10);
        if ((this.count - numAux) < limitInferior){
            try{
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            this.count -= numAux;
            System.out.println("Decrement: " + numAux);
            System.out.println("Valor atual " + this.count);
        }
        this.empty = false;
        notifyAll();
    }
}
