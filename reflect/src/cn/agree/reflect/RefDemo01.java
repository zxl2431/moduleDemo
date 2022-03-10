package cn.agree.reflect;

import cn.agree.pojo.Student;

public class RefDemo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        *  1、Java中使用Class 表示某个class文件
        *  2、任何一个class文件都是Class这个类的一个实例对象
        * */

        /*
        *  方式一: 通过类名.class获取 Class对象
        * */
        Class c1 = Student.class;
        System.out.println(c1);

        /*
        *  方式二:通过Object类的成员方法getClass()方法获取
        *
        * */
        Student stu = new Student();
        Class c2 = stu.getClass();
        System.out.println(c2);

        /*
        *  方式三:通过Class.forName("全限定类名")方法获取
        *
        * */
        Class c3 = Class.forName("cn.agree.pojo.Student");
        System.out.println(c3);
    }
}
