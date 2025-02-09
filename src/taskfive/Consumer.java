package taskfive;

public class Consumer implements Runnable {

    private MyQueue queue;
    private String color;

    public Consumer(MyQueue queue, String color) {
        this.queue = queue;
        this.color = color;
    }

    @Override
    public void run() {
        queue.getElement(color);
    }

}