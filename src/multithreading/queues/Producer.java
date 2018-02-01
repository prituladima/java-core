package multithreading.queues;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer extends Thread{

    private long workingTime;
    private BlockingQueue<Integer>  queue;
    private int amount;

    public Producer(long workingTime, BlockingQueue<Integer> queue, int amount) {
        this.workingTime = workingTime;
        this.queue = queue;
        this.amount = amount;
    }

    @Override
    public void run() {

        for(int index = 0; index < amount; index++) {
            try {
                Thread.sleep(workingTime);
                System.out.println("produce - " + index);
                queue.offer(new Random().nextInt(), 1L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {

            }
        }
    }
}
