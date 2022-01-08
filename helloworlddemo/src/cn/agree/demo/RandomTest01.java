package cn.agree.demo;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomTest01 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
    }
}
