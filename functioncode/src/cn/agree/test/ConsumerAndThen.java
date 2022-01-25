package cn.agree.test;

import java.util.function.Consumer;

public class ConsumerAndThen {
    private static void consumerString(Consumer<String> one, Consumer<String> two) {
        one.andThen(two).accept("Hello");
    }

    public static void main(String[] args) {
        consumerString(s -> System.out.println(s.toUpperCase()), s -> System.out.println(s.toLowerCase()));
    }
}
