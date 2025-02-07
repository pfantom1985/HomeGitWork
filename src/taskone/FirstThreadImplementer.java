package Task_1;

public class FirstThreadImplementer implements Runnable {

    ThreadPrinter printer;
    private String color;

    FirstThreadImplementer(ThreadPrinter printer, String color) {
        this.printer = printer;
        this.color = color;
    }

    public void run() {
        for (int i = 0; i < ThreadLauncher.TREAD_COUNTER; i++) {
            printer.FirstMessageOutput(color);
        }
    }

}
