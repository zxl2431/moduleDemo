package cn.agree.reflect;

/*
*  编写一个工厂方法可以根据配置文件产生任意类型对象
*
* */

import cn.agree.pojo.Student;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Set;

public class RefDemo06 {
    public static void main(String[] args) {
        // 获取对象
        Student stu = (Student) createObject();
        // 输出对象
        System.out.println(stu);
    }

    /*
    *  根据配置文件创建对象
    * */
    public static Object createObject() {
        try {
            // 创建属性集合
            Properties pro = new Properties();
            pro.load(RefDemo06.class.getResourceAsStream("/stu.properties"));
            System.out.println(pro);

            // 从集合中获取类名 就是全限定名
            String className = pro.getProperty("class");
            // 通过反射获取Class对象 全限定名
            Class c = Class.forName(className);
            // 快速创建对象
            Object obj = c.newInstance();

            // 遍历集合
            Set<String> names = pro.stringPropertyNames();
            for (String name : names) {
                if (name.equals("class")) continue;
                // 获取值
                String value = pro.getProperty(name);
                Field f = c.getDeclaredField(name);
                // 暴力反射
                f.setAccessible(true);
                // 获取成员变量的类型
                Class typeClass = f.getType();
                if (typeClass == int.class) {
                    f.setInt(obj, Integer.parseInt(value));
                } else {
                    f.set(obj,value);
                }

            }

            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
