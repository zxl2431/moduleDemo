package cn.agree.custthread;

public class BaoZiPu extends Thread {
    private BaoZi bz;

    public BaoZiPu(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                System.out.println(Thread.currentThread().getName()+"抢到了资源");
                // 有包子就进入 waiting 状态
                if (bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 没有包子 就开始干
                System.out.println("包子铺开始生产包子");
                if (count%2 == 0) {
                    bz.pier = "灰面";
                    bz.xianner = "牛肉";
                } else {
                    bz.pier = "厚皮";
                    bz.xianner="猪肉";
                }
                count++;

                bz.flag = true;
                System.out.println("包子造好了:" + bz.pier + bz.xianner);
                System.out.println("吃货来吃");
                bz.notify();
            }
        }
    }
}
