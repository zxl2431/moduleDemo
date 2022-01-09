package cn.agree.demo;

import cn.agree.pojo.Game;

public class StaticTest01 {
    public static void main(String[] args) {
        /*
        *  1. static修饰的变量是类变量,与对象无关.在内存中放的地方是方法区中的静态区
        *  2. static修饰的方式是类方法,与对象无关,在不创建类的情况下可以直接调用
        *  3. static静态代码块, 随着类的加载而执行一次,优于main方法和构造方法的执行
        *
        * */

        /*
        *  类方法:静态方法调用的注意事项
        *  1,静态方法可以直接访问 --> 类变量和静态方法
        *  2,静态方法不能直接访问普通成员变量和成员方法, 反之是可以的
        *  3,静态方法中,不能使用this关键字.因为this关键字是属于对象的
        *
        * */

        Game.showGame();
    }
}
