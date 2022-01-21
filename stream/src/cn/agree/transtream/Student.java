package cn.agree.transtream;

import java.io.Serializable;

public class Student implements Serializable{
    // 加入序列版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
