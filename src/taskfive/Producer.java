package taskfive;

public class Producer implements Runnable {

    private MyQueue queue;
    private String color;

    public Producer(MyQueue queue, String color) {
        this.queue = queue;
        this.color = color;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3334; i++) {
            queue.putElement(i, color);
        }
    }

}