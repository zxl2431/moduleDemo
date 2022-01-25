package cn.agree.test;

import java.util.function.Supplier;

public class IntArrayTest01 {
    /*
    *  Supplier 接口就一个方法 get()
    *  多用于提供数据, 至于怎么提供数据, 可以自己定义
    *
    * */
    private static void printMax(Supplier<Integer> supplier) {
        int max = supplier.get();

        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] array = { 10, 20, 100, 30, 40, 50 };
        printMax(() -> {
            int max = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }

            return max;
        });
    }
}
