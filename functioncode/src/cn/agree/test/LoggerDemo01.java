package cn.agree.test;

public class LoggerDemo01 {
    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";

        log(1, msgA + msgB + msgC);
    }

    public static void log(int level, String msg) {
        if (level == 1) {
            System.out.println(msg);
        }
    }
}
