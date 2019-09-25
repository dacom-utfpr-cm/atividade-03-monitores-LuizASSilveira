package ex3;

/**
 * Escreva um monitor BoundedCounter que possui um valor mı́nimo e máximo. A classe possui dois métodos:
 * increment() e decrement(). Ao alcançar os limites mı́nimo ou máximo,
 * a thread que alcançou deve ser bloqueada.
 *
 * @author luizASSilveira
 * **/


public class main {
    public static void main(String[] args) {
        BoundedCounter monitor = new BoundedCounter();

        new Thread(new ThreadIncrement(monitor)).start();
        new Thread(new ThreadIncrement(monitor)).start();
        new Thread(new ThreadIncrement(monitor)).start();


        new Thread(new ThreadDecrement(monitor)).start();
        new Thread(new ThreadDecrement(monitor)).start();
        new Thread(new ThreadDecrement(monitor)).start();





    }

}
