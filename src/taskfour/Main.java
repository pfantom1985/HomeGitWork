package taskfour;

/*
Задание 57. Создать программу, которая реализует deadlock между тремя потоками.
*/
public class Main {
    public static void main(String[] args) {

        Object firstStreamForDeadlock = new Object();
        Object secondStreamForDeadlock = new Object();
        Object thirdStreamForDeadlock = new Object();

        Thread firstThread = new Thread(() -> {
            synchronized(firstStreamForDeadlock) {
                System.out.println("First stream in ( " + Thread.currentThread().getName() + " ) started.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
                synchronized(secondStreamForDeadlock) {
                    System.out.println("Second stream in first stream in ( " + Thread.currentThread().getName() + " ) started.");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        }, "Thread-1");
        firstThread.start();

        Thread secondThread = new Thread(() -> {
            synchronized (secondStreamForDeadlock) {
                System.out.println("Second stream in ( " + Thread.currentThread().getName() + " ) started.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
                synchronized (thirdStreamForDeadlock) {
                    System.out.println("Third stream in second stream in ( " + Thread.currentThread().getName() + " ) started.");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        }, "Thread-2");
        secondThread.start();

        Thread thirdThread = new Thread(() -> {
            synchronized (thirdStreamForDeadlock) {
                System.out.println("Third stream in ( " + Thread.currentThread().getName() + " ) started.");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
                synchronized (firstStreamForDeadlock) {
                    System.out.println("First stream in third stream in ( " + Thread.currentThread().getName() + " ) started.");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
        }, "Thread-3");
        thirdThread.start();

    }
}