package Task_1;

import java.util.Scanner;

public class ThreadPrinter {

    public static final String RESET = "\033[0m";
    private int counter = 0;

    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();

    public synchronized void FirstMessageOutput(String color) {
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
        System.out.println(color + "Поток (" + Thread.currentThread().getName() + ") выводит " + counter + " сообщение <" + text + ">." + RESET);
        notify();
    }

    public synchronized void SecondMessageOutput(String color) {
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
        System.out.println(color + "Поток (" + Thread.currentThread().getName() + ") выводит " + counter + " сообщение <" + text + ">." + RESET);
        notify();
    }

}
