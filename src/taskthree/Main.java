package taskthree;
/*
Artem.  Создать класс, который умеет писать в консоль переданное сообщение. Создать 20 (или n число) потоков,
        которые будут выводить по очереди сообщения в консоль. Получив доступ к принтеру, поток выводит 5 сообщений
        с паузами между сообщениями в 1 секунду. Затем доступ к принтеру перехватывает следующий поток и выводит
        свои 5 сообщений и так все следующие. Потом снова первый и так далее.
*/
public class Main {

    public static final int TREAD_COUNTER = 20;
    public static final int MESSAGE_COUNTER = 5;
    public static final int MESSAGE_OUTPUT = 5;

    public static void main(String[] args) {

        System.out.print("Enter message text: ");
        Printer printer = new Printer();
        ThreadImplementer threadImplementer = new ThreadImplementer(printer);
        Thread thread;

        for (int i = 1; i <= TREAD_COUNTER; i++) {
                thread = new Thread(threadImplementer, "Thread-" + i);
                thread.start();
        }

    }
}
