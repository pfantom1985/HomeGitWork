package Task_1;

/*
Artem.  Создать класс принтер, который умеет писать в консоль переданное сообщение. Создать два потока, которые
        будут выводить по очереди сообщения в консоль. Получив доступ к принтеру, поток выводит 5 сообщений
        с паузами между сообщениями в 1 секунду. Затем доступ к принтеру перехватывает следующий поток и выводит
        свои 5 сообщений. Потом снова первый и так далее (вариант 3).
*/

public class ThreadLauncher {

    public static final int TREAD_COUNTER = 20; // Установить количество выводимых сообщений.
    public static final String RED = "\033[0;31m";
    public static final String BLUE = "\033[0;34m";

    public static void main(String[] args) {

        System.out.print("Введите текст сообщения: ");
        ThreadPrinter printer = new ThreadPrinter();
        FirstThreadImplementer fti = new FirstThreadImplementer(printer, RED);
        SecondThreadImplementer sti = new SecondThreadImplementer(printer, BLUE);
        new Thread(fti, "Thread-1").start();
        new Thread(sti, "Thread-2").start();

    }
}
