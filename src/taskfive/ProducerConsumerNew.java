//package taskfive;
//
//import java.util.Random;
//import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class ProducerConsumerNew implements Runnable {
//
//    private int tempTotalItemsProcessed = MainNew.totalItemsProcessed;
//    private int idConsumer;
//    private int idProducer;
//    private String colorConsumer;
//    private String colorProducer;
//
//    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(MainNew.QUEUE_CAPACITY);
//
//    public ProducerConsumerNew(int idConsumer, String colorConsumer) {
//        this.idConsumer = idConsumer;
//        this.colorConsumer = colorConsumer;
//    }
//
//    public ProducerConsumerNew(String colorProducer, int idProducer) {
//        this.colorProducer = colorProducer;
//        this.idProducer = idProducer;
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
//                System.out.println(colorConsumer + "Consumer-" + idConsumer + " get from queue number (" + item + "). Processed: (" + tempTotalItemsProcessed + "). In queue: " + queue.size() + MainNew.RESET);
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//
//
//        @Override
//        public void run() {
//            Random random = new Random();
//            try {
//                while (tempTotalItemsProcessed < MainNew.TARGET_ITEMS_PROCESSED) {
//                    int item = random.nextInt(100) + 1;
//                    queue.put(item);
//                    System.out.println(colorProducer + "Producer-" + idProducer + " put in queue number (" + item + "). In queue: " + queue.size() + MainNew.RESET);
//                    synchronized (queue) {
//                        while (queue.size() >= MainNew.MAX_QUEUE_SIZE) {
//                            queue.wait();
//                        }
//                        if (queue.size() <= MainNew.MIN_QUEUE_SIZE) {
//                            queue.notifyAll();
//                        }
//                    }
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//
//}