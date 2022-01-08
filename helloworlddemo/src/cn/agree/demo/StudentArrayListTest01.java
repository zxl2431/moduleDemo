package cn.agree.demo;

import cn.agree.pojo.Student;

import java.util.ArrayList;

public class StudentArrayListTest01 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student("Mr.Zhang", 16);
        Student s2 = new Student("Mr.Zhang", 17);
        Student s3 = new Student("Mr.Zhang", 18);

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println(students);

        // for (int i=0; i<students.size(); i++) {
        //     System.out.println(students.get(i).getName()+"---"+students.get(i).getAge());
        // }

        ArrayList<String> list = new ArrayList<>();
        String str1 = "曹操";
        String str2 = "刘备";
        String str3 = "孙权";
        System.out.println(list);
        list.add(str1);
        list.add(str2);
        list.add(str3);
        System.out.println(list);


    }
}
