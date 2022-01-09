package cn.agree.inter;

public interface LiveAble {
    //定义抽象方法
    public abstract void eat();
    public abstract void sleep();

    // 定义默认方法
    public default void fly() {
        System.out.println("还能天上飞啊");
        func1();
        func2();
    }

    // 定义静态方法
    public static void run() {
        System.out.println("跑起来");
    }

    /*
    *  定义私有方法
    *  私有方法只有默认方法可以调用
    *
    * */
    private void func1() {
        System.out.println("私有方法一");
    }

    private void func2() {
        System.out.println("私有方法二");
    }
}
