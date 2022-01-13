package cn.agree.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest01 {
    public static void main(String[] args) {
        /*
        *  LinkedHashSet
        *  1. 有序
        *
        * */
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("cba");
        linkedHashSet.add("nba");
        linkedHashSet.add("cuba");
        linkedHashSet.add("bbc");
        linkedHashSet.add("abc");

        System.out.println(linkedHashSet);


    }
}
