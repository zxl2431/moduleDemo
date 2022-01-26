package cn.agree.stream2;

import java.util.function.Predicate;

public class PredicateTest02 {
    public static void main(String[] args) {
        preAnd("helloWorld", s -> s.contains("H"), s->s.contains("W"));
        preOr("helloWorld", s -> s.contains("H"), s->s.contains("W"));
    }

    private static void preAnd(String msg, Predicate<String> one, Predicate<String> two) {
        boolean isValid = one.and(two).test(msg);
        System.out.println("字符串符合要求么:"+isValid);
    }

    private static void preOr(String msg, Predicate<String> one, Predicate<String> two) {
        boolean isValid = one.or(two).test(msg);
        System.out.println("OR符合条件么:"+isValid);

    }
}
