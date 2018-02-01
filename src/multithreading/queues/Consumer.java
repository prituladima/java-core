package multithreading.queues;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{

    private long workingTime;
    private BlockingQueue<Integer>  queue;
    private int amount;

    public Consumer(long workingTime, BlockingQueue<Integer> queue, int amount) {
        this.workingTime = workingTime;
        this.queue = queue;
        this.amount = amount;
    }

    @Override
    public void run(){

        for(int index = 0; index < amount; index++) {
            try {
                Thread.sleep(workingTime);
                System.out.println("consume - " + index);
                System.out.println(queue.poll());
            } catch (InterruptedException e) {

            }


        }
    }
}
