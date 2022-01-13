package cn.agree.set;

import java.util.HashSet;

public class HashSetTest01 {
    public static void main(String[] args) {
        /*
        *  Set接口中的元素
        *  1. 无序
        *  2. 不重复
        *
        * */
        // 创建Set集合
        HashSet<String> set = new HashSet<>();

        // 添加元素
        set.add("cba");
        set.add("nba");
        set.add("cuba");
        set.add("abc");
        set.add("bbc");
        // 是一个重复的
        set.add("cba");

        for (String name : set) {
            System.out.println(name);
        }

        System.out.println("-----------------------");
        System.out.println("cba".hashCode());
        System.out.println("nba".hashCode());

    }
}
