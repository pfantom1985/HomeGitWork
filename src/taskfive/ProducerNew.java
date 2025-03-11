//package taskfive;
//
//import java.util.Random;
//import java.util.concurrent.BlockingQueue;
//
//public class ProducerNew implements Runnable {
//
//    private int tempTotalItemsProcessed = MainNew.totalItemsProcessed;
//    private int id;
//    private String color;
//    BlockingQueue<Integer> queue;
//
//    public ProducerNew(int id, String color, BlockingQueue<Integer> queue) {
//        this.id = id;
//        this.color = color;
//        this.queue = queue;
//    }
//
//    @Override
//    public void run() {
//        Random random = new Random();
//        try {
//            while (tempTotalItemsProcessed < MainNew.TARGET_ITEMS_PROCESSED) {
//                int item = random.nextInt(100) + 1;
//                queue.put(item);
//                System.out.println(color + "Producer-" + id + " put in queue number (" + item + "). In queue: " + queue.size() + MainNew.RESET);
//                synchronized (queue) {
//                    while (queue.size() >= MainNew.MAX_QUEUE_SIZE) {
//                        queue.wait();
//                    }
//                    if (queue.size() <= MainNew.MIN_QUEUE_SIZE) {
//                        queue.notifyAll();
//                    }
//                }
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}