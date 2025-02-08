package taskthree;

import java.util.Scanner;

public class ThreadImplementer implements Runnable {

    private final Printer printer;

    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();

    public ThreadImplementer(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        for (int i = 1; i <= Main.MESSAGE_COUNTER; i++) {
            printer.messageOutput(text);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
