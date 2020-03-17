package exercicio3;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
  * Create a Thread that interrupt a thread and do a clean finish
  * @author Dennis Urtubia
  */

public class Exercicio3 extends Thread {
    @Override
    public void run() {
        try {
            final File fileObject = new File("phrases.txt");
            final Scanner myReader = new Scanner(fileObject);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                Thread.sleep(10000);
            }

            myReader.close();
        } catch (FileNotFoundException fe) {
            System.out.println("Error opening file.");
            fe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(final String[] args) {
        final Exercicio3 thread = new Exercicio3();
        thread.start();

        try {
            thread.sleep(15000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}