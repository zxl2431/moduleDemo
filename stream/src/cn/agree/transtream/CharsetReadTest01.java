package cn.agree.transtream;

import java.io.*;

public class CharsetReadTest01 {
    public static void main(String[] args) throws IOException {
        /*
        *  在IDEA的设置中,都是默认UTF-8编码,所以没有任何问题
        *  但是在Windows系统中创建文本文件时 windows系统默认是GBK
        *  这就会出现乱码问题
        *
        * */
        FileInputStream fis = new FileInputStream("E:/java.txt");
        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        int read;

        while ((read = isr.read()) != -1) {
            System.out.println((char) read);
        }

        isr.close();
    }
}
