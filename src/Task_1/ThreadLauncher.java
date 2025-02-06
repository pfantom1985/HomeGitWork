package Task_1;

public class ThreadLaunch {
    public static void main(String[] args) {

        //Store store = new Store();
        ThreadPrinter printer = new ThreadPrinter();

        //Producer producer = new Producer(store);
        FirstThreadImplementer fti = new FirstThreadImplementer(printer);

        //Consumer consumer = new Consumer(store);
        SecondThreadImplementer sti = new FirstThreadImplementer(printer);

        new Thread(fti, "Thread-1").start();
        new Thread(sti, "Thread-2").start();

    }
}
