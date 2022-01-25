package cn.agree.test;

import cn.agree.interfac.Eatable;

public class EatableTest01 {
    public static void main(String[] args) {
        keepAlive(() -> System.out.println("吃饭饭"));
    }

    public static void keepAlive(Eatable human) {
        human.eat();
    }
}
