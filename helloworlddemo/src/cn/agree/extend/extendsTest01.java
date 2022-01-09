package cn.agree.extend;

import cn.agree.pojo.Teacher;

public class extendsTest01 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "小明";
        teacher.work();
        teacher.printName();
        System.out.println("---------------------");
        // System.out.println(teacher.age);
        teacher.showAge();

        /*
        *  关于继承的构造方法说明
        *  1, 构造方法的名字和类名一致, 所以子类无法继承父类的构造方法
        *  2, 构造方法作用是初始化成员变量,所以子类的初始化过程中,必须先执行父类的初始化动作
        *  子类的构造函数中默认有一个super() 表示调用父类的构造方法.
        *  super: 代表父类的存储空间标识 就是父类的引用
        *  this:代表当前对象的引用
        *
        * */
    }
}
