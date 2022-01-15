package cn.agree.custthread;

public class MyThread extends Thread {
    // 指定线程的名称
    public MyThread(String name) {
        super(name);
    }

    /*
    *  重写run方法
    * */

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":正在执行!"+ i);
        }
    }
}
