package cn.agree.custthread;

public class Ticket implements Runnable {
    private int ticket = 100;

    Object lock = new Object();
    /*
    *  执行卖票的操作
    *
    * */
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket > 0) {
                    // 出票
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    String name = Thread.currentThread().getName();
                    System.out.println(name + "正在卖:"+ ticket--);
                } else {
                    break;
                }
            }


        }
    }
}
