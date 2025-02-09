package tasksixth;
/*
Задание 70. Создайте простейший логгер, выводящий сообщения об ошибках в текстовый файл. Объект логгера
            должен быть создан с помощью шаблона проектирования Singleton. У объекта должен быть обязательным
            один метод, получающий на вход текст сообщения об ошибке и записывающий его в файл вместе
            с информацией о дате и времени происшествия.
*/
import java.util.Scanner;

public class LoggerMain {
    public static void main(String[] args) {

        System.out.print("Enter the message: ");
        Scanner scanner = new Scanner(System.in);
        String logText = scanner.nextLine();

        LoggerSingleton loggerSingleton = LoggerSingleton.getInstance(logText);
        System.out.print("The following text ( " + loggerSingleton.informationalText + " )");
        loggerSingleton.fileWriter(logText);

    }
}