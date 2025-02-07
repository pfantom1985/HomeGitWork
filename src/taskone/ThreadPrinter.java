package taskone;

import java.util.Scanner;

public class ThreadPrinter {

    private int counter = 0;

    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();

    public synchronized void firstMessageOutput(String messageColor) {
        while (counter % 10 == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        counter++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        System.out.println(messageColor + Thread.currentThread().getName() + " displays " + counter + " message <" + text + ">." + Main.RESET);
        notify();
    }

    public synchronized void secondMessageOutput(String messageColor) {
        while (counter % 10 == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        counter++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.getStackTrace();
        }
        System.out.println(messageColor + Thread.currentThread().getName() + " displays " + counter + " message <" + text + ">." + Main.RESET);
        notify();
    }

}
