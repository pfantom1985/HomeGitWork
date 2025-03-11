package taskfivefalse;

public class Producer implements Runnable {

    private MyQueue queue;
    private String color;

    public Producer(MyQueue queue, String color) {
        this.queue = queue;
        this.color = color;
    }

    @Override
    public void run() {
        queue.putElement(color);
    }

}