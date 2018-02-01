package multithreading.semaphore;

public class Putter extends Thread {

    ConcurentObject object;


    public Putter(ConcurentObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){


            object.put("" + i);
        }
    }
}
