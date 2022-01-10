package cn.agree.extend;

import cn.agree.pojo.FlyAble;

public class AnonymousInnerClassTest01 {
    public static void main(String[] args) {
        /*
        * 定义并创建该接口的子类对象
        * 多态接着 一般是不这么玩的
        *
        * */
        FlyAble f = new FlyAble() {
            @Override
            public void fly() {
                System.out.println("我飞了");
            }
        };

        // 这个是属于直接调用了
        // f.fly();
        showFly(f);

        // 一般都是直接玩
        showFly(new FlyAble() {
            @Override
            public void fly() {
                System.out.println("来来来,飞给我看");
            }
        });

    }

    public static void showFly(FlyAble f) {
        f.fly();
    }
}
