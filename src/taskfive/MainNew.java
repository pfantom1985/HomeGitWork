//package taskfive;
///*
//Задание 58. Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно. Есть очередь
//            с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
//            Если в очереди элементов >= 100 производители спят, если нет элементов в очереди - потребители спят.
//            Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор, пока обработанных
//            элементов не станет 10000, только потом программа завершается.
//*/
//
//import java.util.concurrent.*;
//
//public class MainNew {
//
//    private static final String RED = "\033[0;31m";
//    private static final String GREEN = "\033[0;32m";
//    protected static final String RESET = "\033[0m";
//    protected static final int MAX_QUEUE_SIZE = 100;
//    protected static final int MIN_QUEUE_SIZE = 80;
//    protected static final int TARGET_ITEMS_PROCESSED = 10000;
//    protected static final int QUEUE_CAPACITY = 200;
//    protected static int totalItemsProcessed = 0;
//
//    public static void main(String[] args) {
//
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//
//        for (int i = 0; i < 2; i++) {
//            executor.submit(new ConsumerNew(i, RED));
//        }
//
//        for (int i = 0; i < 3; i++) {
//            executor.submit(new ProducerNew(GREEN, i));
//        }
//
//
//
//        executor.shutdown();
//    }
//}
