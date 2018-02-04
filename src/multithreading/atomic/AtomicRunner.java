package multithreading.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static multithreading.locks.SynchronizedCodeRunner.stop;

public class AtomicRunner {

    public static void main(String[] args) {

        AtomicInteger atomicInt = new AtomicInteger(0);
        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);

//        IntStream.range(0, 1000)
//                .forEach(i -> executor.submit(atomicInt::incrementAndGet));
//

//        IntStream.range(0, 1000)
//                .forEach(i -> {
//                    Runnable task = () ->
//                            atomicInt.updateAndGet(n -> n + 2);
//                    executor.submit(task);
//                });

        IntStream.range(1, 1001)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.accumulateAndGet(i, (n, m) -> n + m);
                    counter.incrementAndGet();
                    executor.submit(task);
                });

        stop(executor);

        System.out.println(atomicInt.get());    // => 1000
        System.out.println(counter.get());
    }

}
