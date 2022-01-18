package cn.agree.recur;

public class FactorialRecursion {
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);

    }

    public static int factorial(int n) {
        // 定义一个出口
        if (n==1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }


    }
}
