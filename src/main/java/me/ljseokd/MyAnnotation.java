package me.ljseokd;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 기본값 : Class -  Class로 하면 클래스 로딩 시점에 메모리에 올리지 않는다.
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited // 상속 O
public @interface MyAnnotation {

    String value();

    int number() ;

}
