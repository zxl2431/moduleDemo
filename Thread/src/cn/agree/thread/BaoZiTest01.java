package cn.agree.thread;

import cn.agree.custthread.BaoZi;
import cn.agree.custthread.BaoZiPu;
import cn.agree.custthread.ChiHuo;

public class BaoZiTest01 {
    public static void main(String[] args) {
        // 等待唤醒
        BaoZi baoZi = new BaoZi();

        ChiHuo chihuo = new ChiHuo("吃货", baoZi);
        BaoZiPu baoZiPu = new BaoZiPu("包子铺", baoZi);

        chihuo.start();
        baoZiPu.start();
    }
}
