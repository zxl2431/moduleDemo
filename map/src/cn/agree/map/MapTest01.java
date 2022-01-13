package cn.agree.map;

import java.util.HashMap;
import java.util.Set;

public class MapTest01 {
    public static void main(String[] args) {
        // 创建Map对象
        HashMap<String, String> map = new HashMap<>();

        //添加元素到集合
        map.put("黄晓明", "杨颖");
        map.put("文章", "马伊琍");
        map.put("邓超", "孙俪");
        map.put("胡歌", "霍建华");
        map.put("郭德纲", "于谦");
        map.put("薛之谦", "大张伟");
        System.out.println(map);

        System.out.println(map.remove("黄晓明"));
        System.out.println(map);

        System.out.println(map.get("邓超"));

        // Map的遍历
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(key+"的CP是:"+value);
        }
    }
}
