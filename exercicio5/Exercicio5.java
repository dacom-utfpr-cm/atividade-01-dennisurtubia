package exercicio5;

import java.util.Random;
import java.util.Scanner;

/**
  * Program that create a thread for sum a N numbers
  * @author Dennis Urtubia
  */

public class Exercicio5 extends Thread {
    int sum = 0;

    @Override
    public void run() {
        Random rand = new Random();
        int numberInputs = rand.nextInt(10);

        System.out.println("Number of inputs: " + numberInputs);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numberInputs; i++) {
            sum += scanner.nextInt();
        }
        
        System.out.println("Sum result: " + sum);
        scanner.close();
    }

    public static void main(String[] Args) throws InterruptedException {
        Exercicio5 thread = new Exercicio5();
        thread.start();
        
        thread.join();
    }
}