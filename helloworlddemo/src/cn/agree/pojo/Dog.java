package cn.agree.pojo;

public class Dog extends Animal {
    @Override
    public void run() {
        System.out.println("狗子跑起来也没有声音,但是狗子会叫");
    }

    public void watchHouse() {
        System.out.println("狗看家");
    }
}
