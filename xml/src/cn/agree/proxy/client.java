package cn.agree.proxy;

import java.lang.reflect.Proxy;

public class client {
    public static void main(String[] args) {
        JinPan pan = new JinPan();

        // 通过代理调用happyWithMan()
        MyInvocationHandler imp = new MyInvocationHandler(pan);

        KindWomen women = (KindWomen) Proxy.newProxyInstance(client.class.getClassLoader(), JinPan.class.getInterfaces(), imp);

        // 代理对象调用任何方法 都会都用InvocationHandler实现对象的invoke方法
        women.happyWithMan();
        double money = women.collect(500);
        System.out.println("金莲最终拿到的"+money);

    }
}
