package taskone;

public class SecondThreadImplementer implements Runnable {

    ThreadPrinter printer;
    private String messageColor;

    public SecondThreadImplementer(ThreadPrinter printer, String messageColor) {
        this.printer = printer;
        this.messageColor = messageColor;
    }

    public void run() {
        for (int i = 0; i < Main.TREAD_COUNTER; i++) {
            printer.secondMessageOutput(messageColor);
        }
    }

}
