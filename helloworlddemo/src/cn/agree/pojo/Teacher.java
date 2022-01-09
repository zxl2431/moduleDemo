package cn.agree.pojo;

public class Teacher extends Employee {

    public int age = 28;

    public Teacher() {
        System.out.println("子类的构造方法");
    }

    public void printName() {
        System.out.println("name="+name);
    }

    public void showAge() {
        System.out.println("父亲的年龄:"+super.age);
        System.out.println("儿子的年龄:"+this.age);
    }

    @Override
    public void work() {
        System.out.println(name+"997这个更狠");
    }
}
