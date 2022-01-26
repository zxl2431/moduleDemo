package cn.agree.stream2;

import java.util.function.Function;

public class FunctionTest01 {
    public static void main(String[] args) {
        // System.out.println("10" + 20);
        // funApply(s -> Integer.parseInt(s));
        funApply(Integer::parseInt);
        funAndThen(Integer::parseInt, i -> i*10);
    }

    private static void funApply(Function<String, Integer> function) {
        Integer num = function.apply("10");
        System.out.println(num + 20);
    }

    private static void funAndThen(Function<String, Integer> one, Function<Integer, Integer> two) {
        int num = one.andThen(two).apply("5");
        System.out.println(num+20);
    }
}
