package cn.agree.thread;

import cn.agree.custthread.MyThread;

public class ThreadTest01 {
    public static void main(String[] args) {

        MyThread myThread = new MyThread("新的线程");
        myThread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main线程"+i);
        }
    }
}
