package taskfive;

import java.util.ArrayDeque;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue {

    private ReentrantLock locker;
    private Condition condition;

    Random random = new Random();
    ArrayDeque<Integer> digitalQueue = new ArrayDeque<>(Main.CAPACITY);

    public MyQueue() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public void getElement(int i, String color) {
        locker.lock();
        try {
            while (digitalQueue.isEmpty()) {
                condition.await();
            }
            System.out.println(color + "Потребитель < " + Thread.currentThread().getName() + " > взял одно из ( " + i + " ) число: " + digitalQueue.pollLast() + "." + Main.RESET);
            System.out.println(color + "Чисел в очереди: " + digitalQueue.size() + "." + Main.RESET);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public void putElement(int i, String color) {
        locker.lock();
        try {
            while (digitalQueue.size() > 80) {
                condition.await();
            }
            int randomNumber = random.nextInt(99) + 1;
            digitalQueue.addLast(randomNumber);
            System.out.println(color + "Производитель < " + Thread.currentThread().getName() + " > внес одно из < " + i + " > число: " + randomNumber + "." + Main.RESET);
            System.out.println(color + "Чисел в очереди: " + digitalQueue.size() + "." + Main.RESET);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

}