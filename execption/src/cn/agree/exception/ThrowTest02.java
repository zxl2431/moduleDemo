package cn.agree.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowTest02 {
    public static void main(String[] args) throws IOException {
        read("C.txt");
        System.out.println("后面不执行了吧");
    }

    public static void read(String path) throws IOException {
        if (!path.equals("a.txt")) {
            throw new FileNotFoundException("兄弟,文件不存在啊~~~");
        }

        if (!path.equals("b.txt")) {
            throw new IOException();
        }
    }
}
