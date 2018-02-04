package java8;

public class MethodRefRunner {

    public static void main(String[] args) {

        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");

        Logger logger = System.out::println;
        logger.d(converted); // 123

        System.out.println(converted);   // 123

    }

    @FunctionalInterface
    private interface Converter<T, E>{
         E convert(T e);
    }

    @FunctionalInterface
    private interface Logger{
        void d(Object o);
    }

}