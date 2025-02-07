package taskone;

public class FirstThreadImplementer implements Runnable {

    ThreadPrinter printer;
    private String messageColor;

    public FirstThreadImplementer(ThreadPrinter printer, String messageColor) {
        this.printer = printer;
        this.messageColor = messageColor;
    }

    public void run() {
        for (int i = 0; i < Main.TREAD_COUNTER; i++) {
            printer.firstMessageOutput(messageColor);
        }
    }

}
