package cn.agree.demo;

import cn.agree.pojo.Student;

public class StudentTest01 {
    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s);

        System.out.println("年龄:"+s.getName());
        System.out.println("姓名:"+ s.getAge());

        s.setName("Mr.Zhang");
        s.setAge(19);

        System.out.println("年龄:"+s.getName());
        System.out.println("姓名:"+ s.getAge());
    }
}
