package taskthree;

public class Printer {

    public synchronized void messageOutput(String text) {
        for (int i = 0; i < Main.MESSAGE_OUTPUT; i++) {
            System.out.println(Thread.currentThread().getName() + " displays message <" + text + ">.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
