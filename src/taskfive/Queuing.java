//package taskfive;

import java.util.ArrayDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//public class Queuing {

    //private static ArrayDeque<Integer> digitalQueue = new ArrayDeque<>(Main.QUEUE_CAPACITY);


    //public void putElement(String color) {
    //    while (tempPutCounter > 1) {
    //        locker.lock();
    //        try {
    //            while (digitalQueue.size() > 80) {
    //                condition.await();
    //            }
    //            int randomNumber = random.nextInt(99) + 1;
    //            digitalQueue.addLast(randomNumber);
    //            System.out.println(color + Thread.currentThread().getName() + " put one of < " + tempPutCounter + " > numbers: " + randomNumber + "." + Main.RESET);
    //            System.out.println(color + "Numbers in queue: " + digitalQueue.size() + "." + Main.RESET);
    //            tempPutCounter--;
    //            condition.signalAll();
    //        } catch (InterruptedException e) {
    //            System.out.println(e.getMessage());
    //        } finally {
    //            locker.unlock();
    //        }
    //    }
    //}

    //public void getElement(String color) {
    //    while (tempGetCounter < Main.NUMBER_OF_DIGITS) {
    //        locker.lock();
    //        try {
    //            while (digitalQueue.isEmpty()) {
    //                condition.await();
    //            }
    //            System.out.println(color + Thread.currentThread().getName() + " get one of ( " + tempGetCounter + " ) numbers: " + digitalQueue.pollLast() + "." + Main.RESET);
    //            System.out.println(color + "Numbers in queue: " + digitalQueue.size() + "." + Main.RESET);
    //            tempGetCounter++;
    //            condition.signalAll();
    //        } catch (InterruptedException e) {
    //            System.out.println(e.getMessage());
    //        } finally {
    //            locker.unlock();
    //        }
    //    }
    //}

//}