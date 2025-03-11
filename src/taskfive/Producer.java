//ackage taskfive;

//mport java.util.ArrayDeque;
//mport java.util.Random;

//ublic class Producer implements Runnable {

//   private ArrayDeque<Integer> digitalQueue;
//   private String color;
//   private int tempCounter = Main.NUMBER_OF_DIGITS;

//   public Producer(ArrayDeque<Integer> digitalQueue, String color) {
//       this.digitalQueue = digitalQueue;
//       this.color = color;
//   }

//   @Override
//   public void run() {
//       Random random = new Random();
//       try {
//           while (Main.digits_counter < tempCounter) {
//               int randomNumber = random.nextInt(100) + 1;
//               digitalQueue.addLast(randomNumber);
//               System.out.println(color + Thread.currentThread().getName() + " put one of < " + tempCounter + " > numbers: " + randomNumber + "." + Main.RESET);
//               synchronized (digitalQueue) {
//                   tempCounter--;
//                   while (digitalQueue.size() >= Main.MAX_QUEUE_SIZE) {
//                       digitalQueue.wait();
//                   }
//                   if (digitalQueue.size() <= Main.MIN_QUEUE_SIZE) {
//                       digitalQueue.notifyAll();
//                   }
//               }
//           }
//       } catch (InterruptedException e) {
//           Thread.currentThread().interrupt();
//       }
//   }
//
//queue.putElement(color);
