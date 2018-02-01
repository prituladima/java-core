package multithreading.executorservice;


import java.util.*;
import java.util.concurrent.*;

public class EXecutorServiceRunner {

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newSingleThreadExecutor();

        List<Callable<String>> callableList = new ArrayList<>();
        for (int index = 0; index < 2; index++)
            callableList.add(EXecutorServiceRunner::delay);


        List<Future<String>> futureList = service.invokeAll(callableList);//blocked

        for(Future<String> current: futureList)
            System.out.println(current.get());

        Future<String> future = service.submit(EXecutorServiceRunner::delay);
            System.out.println(future.get());

        service.shutdown();

    }

    public static String delay() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        } finally {
            String s = Thread.currentThread().toString();
            System.out.println("Thread is running - " + s);
            return "Results from future - " + s;
        }
    }

}
