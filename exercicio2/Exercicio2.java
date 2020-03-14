package exercicio2;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
  * Create a Thread that every 10 seconds read line from file and print
  * @author Dennis Urtubia
  */

public class Exercicio2 extends Thread {
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
        }
    }

    public static void main(final String[] args) {
        new Exercicio2().start();
    }
}