package cn.agree.extend;

import cn.agree.inter.LiveAble;
import cn.agree.pojo.Person;

public class InterfaceTest01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.eat();
        person.sleep();
        person.fly();
        /*
        *  run()是LiveAble接口中定义的static方法, 只能通过接口名调用
        *  不能通过实现类和类名调用
        * */
        LiveAble.run();

        /*
        *  Java中虽然类的继承是单继承
        *  但是接口的实现是多实现啊
        *
        * */

    }
}
