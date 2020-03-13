package exercicio1;

import java.util.Random;

/**
  * Create three Threads with aleatory sleep.
  * @author Dennis Urtubia
  */

public class Exercicio1 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000) + 1000);
        } catch (InterruptedException e) { }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Exercicio1().start();
        }
    }
}