package cn.agree.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TryCatchTest01 {
    public static void main(String[] args) {
        try {
            read("a.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            // 抓取到的是编译时期的异常, 抛出去的是运行时期的
            // throw new RuntimeException(e);
        } finally {
            System.out.println("我是一定会执行的!");
        }

        System.out.println("over");
    }

    public static void read(String path) throws FileNotFoundException {
        if (!path.equals("a.txt")) {
            throw new FileNotFoundException("兄弟,文件不存在啊~~~");
        }

    }
}
