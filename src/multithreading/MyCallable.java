package multithreading;

public class MyCallable implements Runnable {

    int[] data;

    public MyCallable(boolean isMinus) {
        this.data = new int[1000000];
        for(int i = 0; i<1000000; i++){
            data[i] = i * (isMinus ? -1 : 1);
        }
    }

    @Override
    public void run() {
        System.out.println("thread = " + Thread.currentThread().getName());
        for (int i : data) {
            synchronized (Monitor.class){
                Monitor.sum += i;
            }
        }

    }

}
