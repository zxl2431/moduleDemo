package cn.agree.thread;

import cn.agree.custthread.Ticket;

public class TicketTest {
    public static void main(String[] args) {
        /*
        *   线程安全问题都是由全局变量及静态变量引起的.
        *   如果每个线程对全局变量、静态变量只有读操作
        *   没有写操作,一般来说这个线程是安全的.
        *   如果有写操作,那就会有线程安全的问题.
        *   需要做线程同步 synchronized
        *   三种解决方案:
        *   1. 同步代码块
        *   2. 同步方法
        *   3. 锁机制
        *
        * */
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
