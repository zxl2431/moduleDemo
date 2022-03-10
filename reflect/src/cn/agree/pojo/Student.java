package cn.agree.pojo;

public class Student {
    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }
}
