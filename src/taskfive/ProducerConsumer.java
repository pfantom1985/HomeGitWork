package taskfive;
/*
Задание 58. Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно. Есть очередь
            с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
            Если в очереди элементов >= 100 производители спят, если нет элементов в очереди - потребители спят.
            Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор, пока обработанных
            элементов не станет 10000, только потом программа завершается.
*/

import java.util.Random;
import java.util.concurrent.*;

public class ProducerConsumer {

    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String RESET = "\033[0m";
    private static final int MAX_QUEUE_SIZE = 100;
    private static final int MIN_QUEUE_SIZE = 80;
    private static final int TARGET_ITEMS_PROCESSED = 10000;
    private static final int QUEUE_CAPACITY = 200;
    private static int totalItemsProcessed = 0;

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 3; i++) {
            executor.submit(new Producer(i, GREEN));
        }

        for (int i = 0; i < 2; i++) {
            executor.submit(new Consumer(i, RED));
        }

        executor.shutdown();
    }

    static class Producer implements Runnable {

        private int id;
        private String color;

        public Producer(int id, String color) {
            this.id = id;
            this.color = color;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                while (totalItemsProcessed < TARGET_ITEMS_PROCESSED) {
                    int item = random.nextInt(100) + 1;
                    queue.put(item);
                    System.out.println(color + "Producer-" + id + " put in queue number (" + item + "). In queue: " + queue.size() + RESET);
                    synchronized (queue) {
                        while (queue.size() >= MAX_QUEUE_SIZE) {
                            queue.wait();
                        }
                        if (queue.size() <= MIN_QUEUE_SIZE) {
                            queue.notifyAll();
                        }
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {

        private int id;
        private String color;

        public Consumer(int id, String color) {
            this.id = id;
            this.color = color;
        }

        @Override
        public void run() {
            try {
                while (totalItemsProcessed < TARGET_ITEMS_PROCESSED) {
                    Integer item = queue.take();
                    synchronized (queue) {
                        totalItemsProcessed++;
                        while (queue.isEmpty()) {
                            queue.wait();
                        }
                        if (queue.size() < MAX_QUEUE_SIZE) {
                            queue.notifyAll();
                        }
                    }
                    System.out.println(color + "Consumer-" + id + " get from quere number (" + item + "). Processed: (" + totalItemsProcessed + "). In queue: " + queue.size() + RESET);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
