package cn.agree.pojo;

public class Employee {
    public String name;

    public int age = 50;

    public Employee() {
        System.out.println("父类的构造方法");
    }

    public void work() {
        System.out.println("996福报");
    }
}
