package cn.agree.test;

import cn.agree.interfac.MessageBuilder;

public class LoggerDemo02 {
    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";

        /*
        *  使用Lambda的好处是 只有条件满足才会执行后面的
        *  可以提供性能
        *
        * */
        log(1, () ->{
            System.out.println("Lambda执行了");
            return msgA + msgB + msgC;
        });
    }

    public static void log(int level, MessageBuilder builder) {
        if (level == 1) {
            System.out.println(builder.buildMessage());
        }
    }
}
