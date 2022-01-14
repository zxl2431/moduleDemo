package cn.agree.map;

import java.util.HashMap;

public class MapTest03 {
    public static void main(String[] args) {
        // 目标字符串
        String targetStr = "abcddfhdgjhdsfjs";
        HashMap<Character, Integer> map = new HashMap<>();

        char[] charArray = targetStr.toCharArray();
        System.out.println(charArray);

        System.out.println(charArray.length);
        for (int i = 0; i < charArray.length; i++) {
            // System.out.println(charArray[i]);
            // map.put(charArray[i], 1);
            if(map.containsKey(charArray[i])) {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            } else {
                map.put(charArray[i], 1);
            }
        }

        System.out.println(map);
    }
}
