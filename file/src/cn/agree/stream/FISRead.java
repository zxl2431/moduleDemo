package cn.agree.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISRead {
    public static void main(String[] args) throws IOException {
        // 使用文件名称创建流对象
        FileInputStream fis = new FileInputStream("E:/a.txt");
        // 定义变量,作为有效个数
        int len;
        // 定义字节数组 作为装字节数据的容器
        byte[] bytes = new byte[2];
        // 循环读取
        while((len = fis.read(bytes)) != -1) {
            System.out.println(len);
            // 每次读取之后,把数组变成字符串打印
            System.out.println(new String(bytes, 0, len));
        }

        fis.close();
    }
}
