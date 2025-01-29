package Task_1;

import java.util.Scanner;

/*
Artem.  Создать класс принтер, который умеет писать в консоль переданное сообщение. Создать два потока, которые
        будут выводить по очереди сообщения в консоль. Получив доступ к принтеру, поток выводит 5 сообщений
        с паузами между сообщениями в 1 секунду. Затем доступ к принтеру перехватывает следующий поток и выводит
        свои 5 сообщений. Потом снова первый и так далее.
*/

public class Main {

    public static final int CAPACITY = 5; // Установить количество выводимых сообщений.
    public static final String RED = "\033[0;31m";
    public static final String BLUE = "\033[0;34m";
    public static final String RESET = "\033[0m";

    public static void main(String[] args) {

        System.out.println("Введите текст сообщения: ");
        Printer printer = new Printer();
        ThreadStart commonThreadOne = new ThreadStart(printer, RED);
        ThreadStart commonThreadTwo = new ThreadStart(printer, BLUE);

        for (int i = 1; i < (CAPACITY + 1); i++) {
            Thread threadOne = new Thread(commonThreadOne, "Thread-1");
            threadOne.start();
            Thread threadTwo = new Thread(commonThreadTwo, "Thread-2");
            threadTwo.start();
        }
    }
}

class Printer {

    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();

    synchronized void printText(String color) {
        for (int i = 1; i < 6; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(color + "Поток (" + Thread.currentThread().getName() + ") печатает " + i + " раз сообщение <" + text + ">." + Main.RESET);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}

class ThreadStart implements Runnable {

    private String color;
    Printer printer;

    ThreadStart(Printer printer, String color) {
        this.printer = printer;
        this.color = color;
    }

    @Override
    public void run() {
        printer.printText(color);
    }
}
