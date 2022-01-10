package cn.agree.extend;

import cn.agree.pojo.Animal;
import cn.agree.pojo.Cat;
import cn.agree.pojo.Dog;

public class PolymorphismTest01 {
    public static void main(String[] args) {
        // 多态的形式,创建对象
        // 这个就是向上转型
        Animal animal1 = new Cat();
        // animal.eat();
        animal1.run();

        Animal animal2 = new Dog();
        animal2.run();

        // 多态的好处
        Cat cat = new Cat();
        Dog dog = new Dog();

        showAnimalRun(dog);

    }

    public static void showCatRun(Cat c) {
        c.run();
    }

    public static void showDogRun(Dog d) {
        d.run();
    }

    public static void showAnimalRun(Animal a) {
        a.run();
    }
}
