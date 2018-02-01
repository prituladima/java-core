package multithreading.queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.SynchronousQueue;

public class QueuesRunner {

    public static void main(String[] args) throws InterruptedException{

        BlockingQueue queue = new DelayQueue();

        Producer producer = new Producer(1000L, queue, Integer.MAX_VALUE);
        Consumer consumer = new Consumer(1500L, queue, Integer.MAX_VALUE);

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }

}
