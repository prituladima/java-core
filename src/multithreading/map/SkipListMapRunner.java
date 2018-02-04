package multithreading.map;

import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.IntStream;

public class SkipListMapRunner {

    public static void main(String[] args) {

        ConcurrentSkipListMap map = new ConcurrentSkipListMap();
        IntStream.range(1, 10)
                .forEach(x -> map.put(x, x));
//        map.get("");

        map.entrySet();
    }
    

}
