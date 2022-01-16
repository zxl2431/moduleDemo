package cn.agree.thread;

public class WaitingTest {
    public static Object obj = new Object();

    public static void main(String[] args) {

        // 等待对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName()+ "===获取锁对象,调用wait方法, 进入waiting状态,释放锁对象");
                        try {
                            obj.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"===从wait状态中醒了,继续执行");
                    }
                }
            }
        }, "等待线程").start();

        // 唤醒对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"---------等待三秒");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + "----获取到锁对象,调用notify的方法,释放锁对象");
                    obj.notify();
                }
            }
        }, "唤醒线程").start();

    }
}
