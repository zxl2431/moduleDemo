package cn.agree.pojo;

public class Student {
    // 成员变量
    private String name;
    private int age;

    // 无参构造
    public Student() {
    }

    // 有参够造
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void study() {
        System.out.println("好好学习");
    }

    public void eat() {
        System.out.println("好好吃饭");
    }
}
