package Task_1;

public class SecondThreadImplementer implements Runnable {

    ThreadPrinter printer;
    private String color;

    SecondThreadImplementer(ThreadPrinter printer, String color) {
        this.printer = printer;
        this.color = color;
    }

    public void run() {
        for (int i = 0; i < ThreadLauncher.TREAD_COUNTER; i++) {
            printer.SecondMessageOutput(color);
        }
    }

}
