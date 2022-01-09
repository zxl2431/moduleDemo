package cn.agree.pojo;

import cn.agree.inter.LiveAble;

public class Person implements LiveAble {
    @Override
    public void eat() {
        System.out.println("能吃是福啊");
    }

    @Override
    public void sleep() {
        System.out.println("能睡好爽啊");
    }

    // @Override
    // public void fly() {
    //
    //     System.out.println("人是不能天上飞的,能飞的是超人");
    // }
}
