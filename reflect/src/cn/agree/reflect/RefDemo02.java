package cn.agree.reflect;

import cn.agree.pojo.Student;

public class RefDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("cn.agree.pojo.Student");
        // 获取简单类名
        String simpleName = c.getSimpleName();
        System.out.println("name="+simpleName);

        // 获取完整类名
        String name = c.getName();
        System.out.println("完整类名="+name);

        // 创建对象
        // Student str = (Student) c.newInstance();
        // System.out.println(str);


    }
}
