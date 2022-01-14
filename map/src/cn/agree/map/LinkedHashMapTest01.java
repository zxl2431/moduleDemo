package cn.agree.map;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapTest01 {
    public static void main(String[] args) {
        /*
        *  LinkedHashMap的链表结构
        *  是有序的
        *
        * */
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("邓超", "孙俪");
        linkedHashMap.put("李晨", "范冰冰");
        linkedHashMap.put("刘德华", "朱丽倩");

        Set<String> strings = linkedHashMap.keySet();
        for (String str : strings) {
            System.out.println(str +"---"+ linkedHashMap.get(str));
        }
    }
}
