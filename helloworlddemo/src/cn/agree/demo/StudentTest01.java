package cn.agree.demo;

import cn.agree.pojo.Student;

public class StudentTest01 {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);

        System.out.println("年龄:"+s.name);
        System.out.println("姓名:"+ s.age);

        s.name = "Mr.Zhang";
        s.age = 18;

        System.out.println("年龄:"+s.name);
        System.out.println("姓名:"+ s.age);
    }
}
