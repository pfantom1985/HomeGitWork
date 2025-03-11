//package taskfive;
//
//import java.util.ArrayDeque;
//
//public class Consumer implements Runnable {
//
//    private ArrayDeque<Integer> digitalQueue;
//    private String color;
//    private int tempCounter = Main.digits_counter;
//
//    public Consumer(ArrayDeque<Integer> digitalQueue, String color) {
//        this.digitalQueue = digitalQueue;
//        this.color = color;
//    }
//
//    @Override
//    public void run() {
//            try {
//                while (tempCounter < Main.NUMBER_OF_DIGITS) {
//                    Integer consumerTempNumber = digitalQueue.pollLast();
//                    synchronized (digitalQueue) {
//                        tempCounter++;
//                        while (digitalQueue.isEmpty()) {
//                            digitalQueue.wait();
//                        }
//                        if (digitalQueue.size() < Main.MAX_QUEUE_SIZE) {
//                            digitalQueue.notifyAll();
//                        }
//                    }
//                    System.out.println(color + Thread.currentThread().getName() + " get one of ( " + tempCounter + " ) numbers: " + consumerTempNumber + "." + Main.RESET);
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//}
//queue.getElement(color);
