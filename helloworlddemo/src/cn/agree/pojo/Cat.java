package cn.agree.pojo;

public class Cat extends Animal {
    @Override
    public void run() {
        System.out.println("猫猫跑起来没有声音");
    }

    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}
