package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }


    public static void test1() {

        System.out.println("Test 1. ");
        MyHolder<Number> var = new MyHolder<>();
        var.setElement(1);
        Number number = var.getElement();
        System.out.println("var = " + var);
        System.out.println("var class = " + var.getClass().getSimpleName());
        System.out.println("element class= " + var.getElement().getClass().getSimpleName());

        System.out.println("------------------");

    }

    public static void test2() {
        System.out.println("Test 2. ");
        MyHolder<? extends Number> var = new MyHolder<>(1);
//        var.setElement(1);
        Number number = var.getElement();
        System.out.println("var = " + var);
        System.out.println("var class = " + var.getClass().getSimpleName());
        System.out.println("element class = " + var.getElement().getClass().getSimpleName());

        var.setElement(null);//disadvantage

        System.out.println("------------------");
    }

    public static void test3() {
        System.out.println("Test 3. ");
        MyHolder<?> var = new MyHolder<Integer>(1);
//        var.setElement(1);error
//        Number number = var.getElement();error
        System.out.println("var = " + var);
        System.out.println("var class = " + var.getClass().getSimpleName());
        System.out.println("element class = " + var.getElement().getClass().getSimpleName());

        var.setElement(null);//disadvantage
        Object number = var.getElement();//disadvantage

        System.out.println("------------------");
    }

    public static void test4() {
        System.out.println("Test 4. ");
        MyHolder<? super Number> var = new MyHolder<>(new Object());
        var.setElement(1);
//        Number number = var.getElement();//error
        System.out.println("var = " + var);
        System.out.println("var class = " + var.getClass().getSimpleName());
        System.out.println("element class = " + var.getElement().getClass().getSimpleName());

        Object number = var.getElement();//disadvantage

        System.out.println("------------------");
    }

    public static void test5() {
        List<Number> src = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Number> dsn = new ArrayList<>(Arrays.asList(3, 7, 6, 1, 3, 9));

        System.out.println(src);
        System.out.println(dsn);

        copy(src, dsn);

        System.out.println(src);
        System.out.println(dsn);

    }

    public static void copy(List<? extends Number> src, List<? super Number> dsn) {
        assert src.size() == dsn.size();

        for(int index = 0; index < src.size(); index++)
            dsn.set(index, src.get(index));


    }

    public static void test6(){
        System.out.println("Test 6. ");
        MyHolder var = new MyHolder<>(1);
        var.setElement(1);
//        Number number = var.getElement();
        System.out.println("var = " + var);
        System.out.println("var class = " + var.getClass().getSimpleName());
        System.out.println("element class = " + var.getElement().getClass().getSimpleName());

        Object number = var.getElement();//disadvantage

        System.out.println("------------------" + "${Thread.currentThread().name}");
    }

    public static void test7(){
        System.out.println("Test 7. ");

        System.out.println("------------------");
    }

    public static void test8(){
        System.out.println("Test 8. ");

        System.out.println("------------------");
    }

    public static void doOper7(List<? extends Number> list){

    }

    public static <T extends Number> void doOper8(List<T> list){

    }


}
