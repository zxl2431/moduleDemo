package cn.agree.reflect;

import cn.agree.pojo.Student;

import java.lang.reflect.Method;

/*
*  反射获取Class对象的Method信息
*  Method类 是一个方法类
*  类中的每一个方法都是Method的对象, 通过Method对象可以调佣方法
*
* */
public class RefDemo04 {
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class c = Student.class;
        Student stu = (Student) c.newInstance();

        // 获得public修饰的方法对象
        Method m1 = c.getMethod("sleep", int.class);
        // System.out.println(m1);
        // 调用方法m1
        m1.invoke(stu, 8);

        // 获得private修饰的方法对象
        Method m2 = c.getDeclaredMethod("eat");
        m2.setAccessible(true);
        m2.invoke(stu);

        // 获得静态方法对象
        Method m3 = c.getDeclaredMethod("study");
        // 注意: 调用静态方法时, obj可以为null
        m3.invoke(null);

        System.out.println("-------------------获得所有public的方法, 不包括private, 包括父类的------------");
        Method[] ms = c.getMethods();
        for (Method m : ms) {
            System.out.println(m);
        }

        System.out.println("-----------获得所有方法,包括private，不包括父类-----------------------");
        Method[] ms2 = c.getDeclaredMethods();
        // 遍历方法数组
        for (Method m : ms2) {
            System.out.println(m);
        }

    }
}
