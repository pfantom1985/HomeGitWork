package taskseven;

/* Задание 68. Часть 2. */

import java.time.LocalDateTime;

public final class DateService {

    private static DateService INSTANCE;
    //public String value;

    private DateService() {
    }

    //private DateService(String value) {
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException ex) {
        //    ex.printStackTrace();
        //}
    //    this.value = value;
    //}

    public static DateService getLocalDate() {
        if (INSTANCE == null) {
            INSTANCE = new DateService();
        }
        return INSTANCE;
    }

    public static void getDateTime() {
        System.out.println(LocalDateTime.now());
    }

}