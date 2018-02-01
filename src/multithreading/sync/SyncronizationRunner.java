package multithreading.sync;

public class SyncronizationRunner {

    public static void main(String[] args) throws InterruptedException{

        Thread thread1 = new Thread(new MyCallable(true));
        Thread thread2 = new Thread(new MyCallable(false));
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("---------");
        System.out.println(Monitor.sum);
    }

}
