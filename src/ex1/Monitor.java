package ex1;
/*
@luizASSilveira
*/

import java.util.ArrayList;

public class Monitor {
    private ArrayList<String> buffer = new ArrayList<>();
    private int sizeBuffer;
    private int contConsumidor = 0;
    private int contPublicador = 0;


    private boolean empty = true;

    public Monitor(int sizeBuffer) {
        this.sizeBuffer = sizeBuffer;
    }

    public synchronized  String take(){
        while ( empty || (this.contPublicador <= this.contConsumidor)) { //or para nao pegar buffer vazio
            try {
                wait();
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }
        empty = true;
        notifyAll();

        String message = this.buffer.get( this.contConsumidor % this.sizeBuffer );
        this.contConsumidor++;

        return message;
    }

    public synchronized void put(String menssage){
        while ( !empty ){
            try {
                wait();
            }catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        empty = false;
        this.buffer.add( this.contPublicador % this.sizeBuffer, menssage);
        this.contPublicador++;

        notifyAll();
    }

    public int getPosition() {
        return this.contConsumidor % this.sizeBuffer;
    }

}