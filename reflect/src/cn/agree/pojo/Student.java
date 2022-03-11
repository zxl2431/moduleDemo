package cn.agree.pojo;

public class Student {
   /* static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }*/

    private String name;
    public String gender;
    private int age;

    public Student(String name, String gender, int age) {
        System.out.println("public 修饰有参数构造方法");
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Student() {
        System.out.println("public 修饰无参数的构造方法");
    }

    private Student(String name, String gender) {
        System.out.println("private 修饰构造方法");
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 普通方法
    public void sleep(){
        System.out.println("睡觉");
    }

    public void sleep(int hour){
        System.out.println("public修饰---sleep---睡" + hour + "小时");
    }

    private void eat(){
        System.out.println("private修饰---eat方法---吃饭");
    }

    // 静态方法
    public static void study(){
        System.out.println("静态方法---study方法---好好学习Java");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }


}
