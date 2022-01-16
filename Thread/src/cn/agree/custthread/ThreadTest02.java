package cn.agree.custthread;

public class ThreadTest02 {
    public static void main(String[] args) {
        /*
        *  实现runnable接口比继承Thread类所具有的优势
        *  1.可以避免java单继承的局限
        *  2.适合多个相同的程序代码的线程去共享同一个资源
        *  3.增加程序的健壮性,实现解耦操作,代码可以被多个线程共享,代码和线程独立
        *  4.线程池只能方法实现Runable或者Callable类线程,不能直接放入继承Thread的类
        *
        * */
        MyRunnable myRunnable = new MyRunnable();
        Thread th = new Thread(myRunnable, "小强");
        th.start();

        for (int i = 0; i < 50; i++) {
            System.out.println("旺财" + i);
        }
    }
}
