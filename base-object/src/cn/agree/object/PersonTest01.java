package cn.agree.object;

public class PersonTest01 {
    public static void main(String[] args) {
        /*
        *  所有类都是默认继承Object类  这个叫做基类或者超类
        *  JDK7开始在java.util包中增加了Objects类 提供一些static方法
        *  供使用很方便
        *
        * */
        Person person1 = new Person("Mr.zhang", 16);
        Person person2 = new Person("Mr.zhang", 16);
        Person person3 = new Person("Mr.zhang", 17);

        // 如果不重写toString()方法打印出来的是地址
        System.out.println(person1);
        // 如果不重写equals()方法 只能比较两个类的地址是否一致
        System.out.println(person1.equals(person2));
        System.out.println(person2.equals(person3));

    }
}
