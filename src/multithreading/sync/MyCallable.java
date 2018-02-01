package multithreading.sync;

public class MyCallable implements Runnable {

    public static final int AMOUNT = 1_000_000_00;
    int[] data;

    public MyCallable(boolean isMinus) {
        this.data = new int[AMOUNT];
        for (int i = 0; i < AMOUNT; i++) {
            data[i] = i * (isMinus ? -1 : 1);
        }
    }

    @Override
    public void run() {
        System.out.println("thread = " + Thread.currentThread().getName());
        for (int i : data) {
            synchronized (Monitor.class) {
                Monitor.sum += i;
            }
        }

    }

}
