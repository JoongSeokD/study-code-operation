package me.ljseokd;

import java.lang.reflect.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("me.ljseokd.Book");

        Constructor<?> constructor = bookClass.getConstructor();
        Book book = (Book)constructor.newInstance();
        System.out.println(book);

        Field a = Book.class.getDeclaredField("B");
//        a.setAccessible(true);
        System.out.println(a.get(null));// 값꺼냄
//        a.set(book, "BBBB");
//        System.out.println(a.get(book));// 값꺼냄
//
//        Method c = Book.class.getDeclaredMethod("c");
//        c.setAccessible(true);
//        c.invoke(book); // 호출
//
//        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
//        int invoke = (int) d.invoke(book, 1, 2);// 리턴값
//        System.out.println(invoke);
    }
}
