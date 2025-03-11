package taskfive;
/*
Задание 58. Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно. Есть очередь
            с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
            Если в очереди элементов >= 100 производители спят, если нет элементов в очереди - потребители спят.
            Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор, пока обработанных
            элементов не станет 10000, только потом программа завершается.
*/

import java.util.ArrayDeque;
import java.util.Random;

public class Main {

    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    //private static final String YELLOW = "\033[0;33m";
    //private static final String BLUE = "\033[0;34m";
    //private static final String VIOLET = "\033[0;35m";
    private static final String RESET = "\033[0m";
    private static final int QUEUE_CAPACITY = 200;
    private static final int MAX_QUEUE_SIZE = 100;
    private static final int MIN_QUEUE_SIZE = 80;
    private static final int NUMBER_OF_DIGITS = 10000;
    private static int digitsCounter = 0;

    private static final ArrayDeque<Integer> digitalQueue = new ArrayDeque<>(QUEUE_CAPACITY);
    private static Random random = new Random();

    public static void main(String[] args) {

        //Queuing queue = new Queuing();
        //Producer producerFirst = new Producer(BLUE);
        //Producer producerSecond = new Producer(GREEN);
        //Producer producerThird = new Producer(VIOLET);
        //Consumer consumerFirst = new Consumer(RED);
        //Consumer consumerSecond = new Consumer(YELLOW);

        for (int i = 0; i < 3; i++) {
            new Thread(new Producer(GREEN), "Producer-" + i).start();
        }
        for (int j = 0; j < 2; j++) {
            new Thread(new Consumer(RED), "Consumer-" + j).start();
        }
        //new Thread(producerSecond, "Producer-2").start();
        //new Thread(producerThird, "Producer-3").start();
        //new Thread(consumerFirst, "Consumer-1").start();
        //new Thread(consumerSecond, "Consumer-2").start();
    }

    static class Producer implements Runnable {

        //private int tempNumberOfDigits = NUMBER_OF_DIGITS - digitsCounter;
        private String color;

        public Producer(String color) {
            this.color = color;
        }

        @Override
        public void run() {
            while (digitsCounter < NUMBER_OF_DIGITS) {
                int randomNumber = random.nextInt(100) + 1;
                digitalQueue.addLast(randomNumber);
                synchronized (digitalQueue) {
                    try {
                        System.out.println(color + Thread.currentThread().getName() + " put in queue " + /*one of <" + (NUMBER_OF_DIGITS - digitsCounter) + "> */ "number (" + randomNumber + "). In queue: " + digitalQueue.size() + RESET);
                        //tempNumberOfDigits--;
                        Thread.sleep(10);
                        while (digitalQueue.size() >= MAX_QUEUE_SIZE) {
                            digitalQueue.wait();
                        }
                        if (digitalQueue.size() <= MIN_QUEUE_SIZE) {
                            digitalQueue.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {

        //protected int tempDigitsCounter = DIGITS_COUNTER;
        private String color;

        public Consumer(String color) {
            this.color = color;
        }

        @Override
        public void run() {
            while (digitsCounter < NUMBER_OF_DIGITS) {
                try {
                    Integer consumerTempNumber = digitalQueue.pollLast();
                    synchronized (digitalQueue) {
                        digitsCounter++;
                        Thread.sleep(5);
                        while (digitalQueue.isEmpty()) {
                            digitalQueue.wait();
                        }
                        if (digitalQueue.size() < MAX_QUEUE_SIZE) {
                            digitalQueue.notifyAll();
                        }
                    }
                    //System.out.println(color + Thread.currentThread().getName() + " get one of (" + digitsCounter + ") numbers: " + consumerTempNumber + ". In queue: " + digitalQueue.size() + RESET);
                    System.out.println(color + Thread.currentThread().getName() + " get number (" + consumerTempNumber + "). Processed items <" + digitsCounter + ">. In queue: " + (digitalQueue.size() - 1) + RESET);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
