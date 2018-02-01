package multithreading.semaphore;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class ConcurentObject {

    public CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    Semaphore semaphore = new Semaphore(1);



    public void put(String value) {
        try {
            System.out.println("Заходим - " + value);
            semaphore.acquire();
            System.out.println("Заход - " + value);
            Thread.sleep(1000);
            copyOnWriteArrayList.add(value);
            System.out.println("Выход - " + value);
            semaphore.release();
            System.out.println("Вышел - " + value);
        }catch (InterruptedException e){

        }
    }


}
