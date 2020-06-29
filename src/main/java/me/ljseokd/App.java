package me.ljseokd;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;

        Field[] fields = bookClass.getFields(); // 퍼블릭만 리턴
        Book book = new Book();
        //Arrays.stream(bookClass.getFields()).forEach(System.out::println);  // 퍼블릭만 리턴
        //Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);  // 퍼블릭 이외에도 모든 필드 조회 가능
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f ->{
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n ", f, f.get(book)); // 바로 접근 불가
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        Arrays.stream(bookClass.getConstructors()).forEach(System.out::println);
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println(MyBook.class.getSuperclass());
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f ->{
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

        for (Field field : fields) {
            //System.out.println("field = " + field);
        }


        Class<? extends Book> aClass = book.getClass();

        Class<?> aClass1 = Class.forName("me.ljseokd.Book");

    }
}
