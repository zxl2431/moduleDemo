package cn.agree.extend;

import cn.agree.pojo.Cat;

public class abstractExtendTest01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run();
        cat.eat();

        /*
        *  1.抽象类是不能创建对象的
        *  2.抽象类中是可以有构造方法的
        *  3.抽象类中,不一定有抽象方法,但是有抽象方法的一定是抽象类
        *  4.抽象类的子类,必须重写父类中所有的抽象方法
        *
        * */
    }
}
