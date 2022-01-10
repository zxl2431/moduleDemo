package cn.agree.extend;

import cn.agree.pojo.Animal;
import cn.agree.pojo.Cat;
import cn.agree.pojo.Dog;

public class PolymorphismTest02 {
    public static void main(String[] args) {
        // 向上转型
        Animal a = new Cat();
        a.run();

        // 向下转型
        // 如果不向下转型 是调用不到catchMouse()的方法的
        Cat cat = (Cat) a;
        System.out.println(a instanceof Dog);
        // Dog dog = (Dog) a;
        // dog.watchHouse();
        cat.catchMouse();
    }
}
