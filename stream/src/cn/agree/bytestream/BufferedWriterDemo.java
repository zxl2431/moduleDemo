package cn.agree.bytestream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:/out.txt"));
        // 写出数据
        bw.write("你好啊");
        // 写出换行
        bw.newLine();
        bw.write("那还是兜不住");
        bw.newLine();
        bw.write("明天股市长虹");
        bw.newLine();
        // 释放资源
        bw.close();
    }
}
