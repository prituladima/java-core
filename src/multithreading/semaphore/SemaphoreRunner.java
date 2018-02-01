package multithreading.semaphore;

public class SemaphoreRunner {

    public static void main(String[] args) {
        ConcurentObject concurentObject = new ConcurentObject();

        new Putter(concurentObject).start();
        new Putter(concurentObject).start();
//        new Putter(concurentObject).start();
//        new Putter(concurentObject).start();
//        new Putter(concurentObject).start();


    }

}
