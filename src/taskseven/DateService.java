package taskseven;

/* Задание 68. Часть 2. */

public final class SingletonMy {

    private static volatile SingletonMy LOCAL_DATE_SINGLETON;
    public String value;

    private SingletonMy(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static SingletonMy getLocalDate(String value) {
        if (LOCAL_DATE_SINGLETON == null) {
            synchronized (SingletonMy.class) {
                if (LOCAL_DATE_SINGLETON == null) {
                    LOCAL_DATE_SINGLETON = new SingletonMy(value);
                }
            }
        }
        return LOCAL_DATE_SINGLETON;
    }

}