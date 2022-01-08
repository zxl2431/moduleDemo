package cn.agree.demo;

import cn.agree.pojo.Student;

public class StudentArrayTest01 {
    public static void main(String[] args) {
        Student[] students = new Student[3];

        students[0] = new Student("Mr.Zhang", 16);
        students[1] = new Student("Mr.Zhang", 17);
        students[2] = new Student("Mr.Zhang", 18);
        // students[3] = new Student("Mr.Zhang", 19);

        System.out.println(students.length);

        for (int i=0; i<students.length; i++) {
            System.out.println(students[i].getName()+"---"+ students[i].getAge());
        }


    }
}
