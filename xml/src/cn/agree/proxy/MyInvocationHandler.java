package cn.agree.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    private void openHouse() {
        System.out.println("战前准备...");
    }

    private void clear() {
        System.out.println("战后清理...");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 判断方法名
        String methodName = method.getName();

        if ("happyWithMan".equals(methodName)) {
            openHouse();
            KindWomen women = (KindWomen) obj;
            women.happyWithMan();
            clear();
            return null;
        }

        if ("collect".equals(methodName)) {
            System.out.println("扣除中介费:"+(double) args[0]*0.4);
            KindWomen women = (KindWomen) obj;
            women.collect((double) args[0]*0.6);
            return (double) args[0]*0.6;
        }

        // 如果调用其他方法
        return method.invoke(obj,args);
    }
}
