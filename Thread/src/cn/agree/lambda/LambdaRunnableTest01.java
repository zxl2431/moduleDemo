package cn.agree.lambda;

public class LambdaRunnableTest01 {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("多线程执行!")).start();
    }
}
