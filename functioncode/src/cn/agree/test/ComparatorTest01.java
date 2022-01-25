package cn.agree.test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest01 {
    public static void main(String[] args) {
        String[] array = {"abc", "ab", "abcd"};
        System.out.println(Arrays.toString(array));
        // Arrays.sort(array, newComparator());
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println(Arrays.toString(array));
    }

    private static Comparator<String> newComparator() {
        return (a, b) -> b.length() - a.length();
    }
}
