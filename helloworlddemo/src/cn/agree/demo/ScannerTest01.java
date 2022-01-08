package cn.agree.demo;

import java.util.Scanner;

public class ScannerTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入:");
        int i = scanner.nextInt();
        System.out.println(i);
        System.out.println(scanner);
    }
}
