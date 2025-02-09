package taskfive;
/*
Задание 58. Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно. Есть очередь
            с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
            Если в очереди элементов >= 100 производители спят, если нет элементов в очереди - потребители спят.
            Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор, пока обработанных
            элементов не станет 10000, только потом программа завершается.
*/
public class Main {

    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String VIOLET = "\033[0;35m";
    public static final String RESET = "\033[0m";
    public static final int CAPACITY = 200;

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        Producer producerFirst = new Producer(queue, RED);
        Producer producerSecond = new Producer(queue, GREEN);
        Producer producerThird = new Producer(queue, YELLOW);
        Consumer consumerFirst = new Consumer(queue, BLUE);
        Consumer consumerSecond = new Consumer(queue, VIOLET);
        new Thread(producerFirst, "Prod-1").start();
        new Thread(producerSecond, "Prod-2").start();
        new Thread(producerThird, "Prod-3").start();
        new Thread(consumerFirst, "Cons-1").start();
        new Thread(consumerSecond, "Cons-2").start();

    }
}