package cn.agree.stream2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamParallelTest01 {
    public static void main(String[] args) {
        // Stream<Integer> stream = Stream.of(10, 20, 30, 40, 50).parallel();
        // stream.forEach(System.out::println);

        Stream<String> stream = Stream.of("10", "20", "30", "40", "50");
        List<String> list = stream.collect(Collectors.toList());
        // Set<String> set = stream.collect(Collectors.toSet());

        for (String str : list) {
            System.out.println(str);
        }
    }
}
