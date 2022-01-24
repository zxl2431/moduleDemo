package cn.agree.test;

import cn.agree.interfac.MyFunctionInterface;

public class FunctionalInterfaceDemo01 {
    public static void main(String[] args) {
        doSomething(() -> System.out.println("Lambda执行了"));

        doSomething(new MyFunctionInterface() {
            @Override
            public void myMethod() {
                System.out.println("按道理是要有个匿名内部类方法重写的");
            }
        });
    }

    public static void doSomething(MyFunctionInterface inter) {
        inter.myMethod();
    }
}
