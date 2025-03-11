package taskseven;
/*
Задание 68. Часть 1. Создайте простейший сервис с методом, который выводит на экран текущую дату.
            Сделайне его Singleton и используйте в основном теле программы.
 */
import java.time.LocalDateTime;

public class ApplicationDateManagement {

    public static void main(String[] args) {

        //String dateOne = String.valueOf(LocalDateTime.now());
        //System.out.println("First try - " + dateOne);
        //DateService singletonOne = DateService.getLocalDate(dateOne);
        //System.out.println("If you see the same value, then singleton was reused ( " + singletonOne.value + " ).");

        DateService.getDateTime();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        DateService.getDateTime();

        //String dateTwo = String.valueOf(LocalDateTime.now());
        //System.out.println("Second try - " + dateTwo);
        //DateService singletonTwo = DateService.getLocalDate(dateTwo);
        //System.out.println("If you see different values, then 2 singletons were created ( " + singletonTwo.value + " ).");

    }
}