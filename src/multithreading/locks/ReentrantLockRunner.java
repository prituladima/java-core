package multithreading.locks;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static multithreading.locks.SynchronizedCodeRunner.sleep;
import static multithreading.locks.SynchronizedCodeRunner.stop;

public class ReentrantLockRunner {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        ReentrantLock lock = new ReentrantLock(true);

        Runnable r = () -> {
            lock.lock();
            try {
                sleep(1);
            } catch (Exception e){
                System.out.println(e);
            } finally{
                lock.unlock();
            }
        };


        executor.submit(r);
        executor.submit(r);
        executor.submit(r);
        executor.submit(r);
        executor.submit(r);



        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
            System.out.println("Lock count: " + lock.getHoldCount());
            System.out.println("Lock thread queue length: " + lock.getQueueLength());
            System.out.println("Lock string: " + lock.toString());

            System.out.println("Lock fairness: " + lock.isFair());

        });

        stop(executor);
    }



}
