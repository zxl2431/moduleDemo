package cn.agree.stream2;

import cn.agree.pojo.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest01 {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        Stream<String> stream1 = one.stream().filter(s->s.length() == 3).limit(3);
        Stream<String> stream2 = two.stream().filter(s -> s.startsWith("张")).skip(2);
        Stream.concat(stream1, stream2).map(Person::new).forEach(System.out::println);
        // stream3.forEach(s -> System.out.println(s));
        // stream1.forEach(s -> System.out.println(s));
        // System.out.println("---------");
        // stream2.forEach(s->System.out.println(s));
    }
}
