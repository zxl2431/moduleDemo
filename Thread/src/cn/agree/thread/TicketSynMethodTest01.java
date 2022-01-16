package cn.agree.thread;

import cn.agree.custthread.TicketSynMethod;

public class TicketSynMethodTest01 {

    public static int num = 50;

    public static void main(String[] args) {
        TicketSynMethod ticketSynMethod = new TicketSynMethod();
        Thread thread1 = new Thread(ticketSynMethod, "吾悦");
        Thread thread2 = new Thread(ticketSynMethod, "友谊");
        Thread thread3 = new Thread(ticketSynMethod, "观澜湖");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
