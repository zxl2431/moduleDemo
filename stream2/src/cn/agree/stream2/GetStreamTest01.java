package cn.agree.stream2;

import java.util.*;
import java.util.stream.Stream;

public class GetStreamTest01 {
    public static void main(String[] args) {
        /*
        *  得到Collection的获取流
        * */
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        System.out.println(stream1);

        HashSet<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        /*
        *
        * 根据Map获取流
        *
        * */
        HashMap<String, String> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<String> valueStream = map.values().stream();
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();


    }
}
