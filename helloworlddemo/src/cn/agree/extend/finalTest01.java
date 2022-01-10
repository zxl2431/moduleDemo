package cn.agree.extend;

import cn.agree.pojo.Cat;

public class finalTest01 {
    public static void main(String[] args) {
        /*
        *  final: 不可改变.可以用来修饰类、方法和变量
        *  类: 被修饰的类,不能被继承
        *  `public final class String` 、`public final class Math` 、`public final class Scanner`
        *  方法: 被修饰的方法,不能被重写
        *  变量: 被修饰的变量,不能被重新赋值
        *
        * */

        //
        final int A; // final修饰的常量一般名称用大写
        A = 10;
        // A = 20; // 会报错的

        final Cat cat = new Cat();
        // cat = new Cat(); // 报错 引用类型用final修饰,地址不能更改 但是值是可以修改的



    }
}
