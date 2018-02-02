package multithreading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedCodeRunner {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10000)
                .forEach(i -> executor.submit(SynchronizedCodeRunner::increment));

        stop(executor);

        System.out.println(count);  // 9965

    }

    static volatile int count = 0;

    static synchronized void increment() {
        count += 1;
    }

    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("termination interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
