package cn.agree.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyTest {
    public static void main(String[] args) throws Exception {
        // 获取MyTestDemo类Class对象
        Class c = MyTestDemo.class;
        // 获取所有的成员方法对象
        Method[] methods = c.getMethods();
        // 创建MyTestDemo类对象
        Object obj = c.newInstance();
        // 遍历数组
        for (Method m:methods) {
            // 判断方法m上是否使用注解MyTest
            if (m.isAnnotationPresent(MyTest.class)) {
                // 执行方法m
                m.invoke(obj);
            }
        }



    }
}
