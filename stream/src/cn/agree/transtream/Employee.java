package cn.agree.transtream;

import java.io.Serializable;

public class Employee implements Serializable {
    // 加入序列版本号
    private static final long serialVersionUID = 1L;
    public String name;
    public String address;
    // transient 瞬态修饰成员,不会被序列化
    public transient int age;

    public Employee(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public void addressCheck() {
        System.out.println("Address check: " + name + "---" + address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
