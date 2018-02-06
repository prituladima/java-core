package java8;

public class MethodRefRunner {

    public static void main(String[] args) {

        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");

        Logger logger = System.out::println;
        logger.d(converted); // 123

        System.out.println(converted);   // 123


        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }

    @FunctionalInterface
    private interface Converter<T, E>{
         E convert(T e);
    }

    @FunctionalInterface
    private interface Logger{
        void d(Object o);
    }


    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }


    static class Person {
        String firstName;
        String lastName;

        //Person() {}

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

}