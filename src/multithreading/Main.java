package multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException{


        new Thread(new MyCallable(true)).start();
        new Thread(new MyCallable(false)).start();

        Thread.sleep(5000);

        System.out.println("---------");
        System.out.println(Monitor.sum);
    }

}
