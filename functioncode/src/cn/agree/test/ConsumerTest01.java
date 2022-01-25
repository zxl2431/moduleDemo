package cn.agree.test;

import java.util.function.Consumer;

public class ConsumerTest01 {
    private static void comsumerString(String msg, Consumer<String> function) {
        function.accept(msg);
    }

    public static void main(String[] args) {
        comsumerString("真的号", (s) -> System.out.println(s));
        // comsumerString(System.out::println);

    }
}
