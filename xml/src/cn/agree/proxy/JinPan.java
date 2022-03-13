package cn.agree.proxy;

public class JinPan implements KindWomen {
    @Override
    public void happyWithMan() {
        System.out.println("正在happy...");
    }

    @Override
    public double collect(double money) {
        return money;
    }
}
