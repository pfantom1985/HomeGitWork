//package taskfive;
//
//import java.util.concurrent.BlockingQueue;
//
//public class ConsumerNew implements Runnable {
//
//    private int tempTotalItemsProcessed = MainNew.totalItemsProcessed;
//    private int id;
//    private String color;
//    BlockingQueue<Integer> queue;
//
//    public ConsumerNew(int id, String color, BlockingQueue<Integer> queue) {
//        this.id = id;
//        this.color = color;
//        this.queue = queue;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (tempTotalItemsProcessed < MainNew.TARGET_ITEMS_PROCESSED) {
//                Integer item = queue.take();
//                synchronized (queue) {
//                    tempTotalItemsProcessed++;
//                    while (queue.isEmpty()) {
//                        queue.wait();
//                    }
//                    if (queue.size() < MainNew.MAX_QUEUE_SIZE) {
//                        queue.notifyAll();
//                    }
//                }
//                System.out.println(color + "Consumer-" + id + " get from queue number (" + item + "). Processed: (" + tempTotalItemsProcessed + "). In queue: " + queue.size() + MainNew.RESET);
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}