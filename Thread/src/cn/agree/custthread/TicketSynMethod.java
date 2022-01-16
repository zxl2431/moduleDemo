package cn.agree.custthread;

import cn.agree.thread.TicketSynMethodTest01;

public class TicketSynMethod implements Runnable {
    // private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            boolean flag = sellTicket();
            if (flag == false) {
                break;
            }
        }
    }

    /*
    *  同步方法
    *  锁对象,是谁调用这个方法 就是谁
    *  隐含锁对象 就是 this
    *
    * */
    public synchronized boolean sellTicket() {
        if (TicketSynMethodTest01.num > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String name = Thread.currentThread().getName();
            System.out.println(name + "正在卖:"+ TicketSynMethodTest01.num--);
            return true;
        } else {
            return false;
        }

    }


}
