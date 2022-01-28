package cn.agree.stream2;

import java.util.stream.Stream;

public class DealStreamTest01 {
    public static void main(String[] args) {
        /*
        *  流模型的常用方法
        *  filter 按条件过滤
        *  count 统计个数
        *  limit 取前几个
        *  skip跳过前几个
        *  map 将流的元素一一映射到另一个流中
        *  concat 两个流的合并
        *  forEach 循环
        * */
        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        // Stream<String> result = original.filter(s -> s.startsWith("张"));
        // System.out.println(result.count());
        Stream<String> result1 = original.limit(1);
        result1.forEach(System.out::println);

    }
}
