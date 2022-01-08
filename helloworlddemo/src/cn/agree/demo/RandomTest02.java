package cn.agree.demo;

import java.util.Random;
import java.util.Scanner;

public class RandomTest02 {
    public static void main(String[] args) {
        Random random = new Random();
        int targetNum = random.nextInt(100)+1;
        // System.out.println(targetNum);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("输入你的猜想");
            int inputNum = scanner.nextInt();
            if (inputNum>targetNum) {
                System.out.println("大了");
            } else if (inputNum<targetNum) {
                System.out.println("小了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }

    }
}
