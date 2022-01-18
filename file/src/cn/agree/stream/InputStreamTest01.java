package cn.agree.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest01 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/a.txt");
        FileInputStream fis1 = new FileInputStream(file);

        /*
        *  循环读取
        *  每次读出来的都是一个byte 所以有中文的时候就会出现乱码
        *  因为中文是两个byte
        *
        * */
        int b;
        while (( b = fis1.read() ) != -1) {
            System.out.println((char) b);
        }

        // 关闭资源
        fis1.close();
    }
}
