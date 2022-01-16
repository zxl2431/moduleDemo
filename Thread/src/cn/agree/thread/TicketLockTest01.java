package cn.agree.thread;

import cn.agree.custthread.TicketLock;

public class TicketLockTest01 {
    public static void main(String[] args) {
        TicketLock ticketLock = new TicketLock();

        Thread t1 = new Thread(ticketLock, "窗口1");
        Thread t2 = new Thread(ticketLock, "窗口2");
        Thread t3 = new Thread(ticketLock, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
