package multithreading.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

import static multithreading.locks.SynchronizedCodeRunner.sleep;
import static multithreading.locks.SynchronizedCodeRunner.stop;

public class StampedLockRunner {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        Runnable readTask = () -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Start reading lock - " + stamp);
                System.out.println(map.get("foo"));
                sleep(1);
            } finally {
                System.out.println("Stop reading lock - " + stamp);
                lock.unlockRead(stamp);
            }
        };

        executor.submit(readTask);
        executor.submit(readTask);

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Start writing lock - " + stamp);
                sleep(1);
                map.put("foo", "bar");
            } finally {
                System.out.println("Finish writing lock - " + stamp);
                lock.unlockWrite(stamp);
            }
        });

        stop(executor);
    }

}
