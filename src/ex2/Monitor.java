package ex2;
/*
@luizASSilveira
*/

import javax.swing.*;

public class Monitor {

    private int count = 0;
    private boolean empty = false;

    public synchronized void increment(){
        while ( empty ){

            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.empty = true;
        this.count++;
        System.out.println("Contador: " + this.count );
        this.empty = false;
        notifyAll();

    }

    public synchronized int sleepUntil(int valor){
        while ( !(valor < this.count) ){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return this.count;
    }



}