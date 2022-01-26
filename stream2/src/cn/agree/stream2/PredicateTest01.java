package cn.agree.stream2;

import java.util.function.Predicate;

public class PredicateTest01 {
    public static void main(String[] args) {
        foo(s -> s.length() > 15);
        foo2("short", s-> s.length()>4);
    }

    public static void foo(Predicate<String> predicate) {
        boolean islong = predicate.test("HelloWorld");
        System.out.println("很长吗?:"+islong);
    }

    public static void foo2(String msg, Predicate<String> predicate) {
        boolean islong = predicate.test(msg);
        System.out.println("很长吗?:"+islong);
    }
}
