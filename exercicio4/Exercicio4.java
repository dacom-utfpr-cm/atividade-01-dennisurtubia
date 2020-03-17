package exercicio4;

import java.util.Random;

/**
  * Create a Thread that observes interrupted threads
  * @author Dennis Urtubia
  */

class ThreadObserver extends Thread {
    Thread[] threads;

    ThreadObserver(final Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < threads.length; i++) {
                // System.out.println("Thread not interrupted " + threads[i].getId());
                if (threads[i].isInterrupted()) {
                    System.out.println("Thread interrupted " + threads[i].getId());
                }
            }
        }
    }
}

public class Exercicio4 extends Thread {
    public static void main(String[] Args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    System.out.println("Hello World");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }

        new ThreadObserver(threads).start();

        Random rand = new Random();
        int indexThread = rand.nextInt(10);

        System.out.println("Index of thread interrupted " + threads[indexThread].getId());

        threads[indexThread].interrupt();
    }   
}
