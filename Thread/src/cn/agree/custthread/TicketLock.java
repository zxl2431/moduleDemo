package cn.agree.custthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketLock implements Runnable {
    private int ticketNum = 80;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticketNum > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String name = Thread.currentThread().getName();
                System.out.println(name + "正在卖:"+ ticketNum--);
                lock.unlock();
            } else {
                lock.unlock();
                break;
            }

        }
    }
}
