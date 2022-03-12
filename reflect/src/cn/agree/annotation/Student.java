package cn.agree.annotation;

/*
*  定义一个名为Student的注解
*
*  注解就是相当于一个类 也可以定义自己的属性
* */
public @interface Student {
    String name();
    int age() default 18;
    String gender() default "男";
}
