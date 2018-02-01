package multithreading.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class QueuesRunner {

    public static void main(String[] args) throws InterruptedException{

        BlockingQueue queue = new ArrayBlockingQueue(1_000_000, true);

        Producer producer = new Producer(0L, queue, 1_000_000);
        Consumer consumer = new Consumer(1L, queue, Integer.MAX_VALUE);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }

}
