package cn.agree.pojo;

public class Student {
    // 成员变量
    private String name;
    private int age;
    // 学生的id
    private int sid;
    // 类变量,记录学生数量,分配学号
    public static int numberOfStudent = 0;

    // 无参构造
    public Student() {
    }

    // 有参够造
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.sid = ++numberOfStudent;
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

    public static void showNum() {
        System.out.println("num:"+numberOfStudent);
    }

    public void study() {
        System.out.println("好好学习");
    }

    public void eat() {
        System.out.println("好好吃饭");
    }
}
