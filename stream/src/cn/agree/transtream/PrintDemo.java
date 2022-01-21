package cn.agree.transtream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 调用系统的打印流
        System.out.println(97);
        // 创建打印流 指定文件的名称
        PrintStream ps = new PrintStream("E:/ps.txt");

        // 设置系统打印流流向 输出到ps.txt
        System.setOut(ps);
        System.out.println(97);


    }
}
