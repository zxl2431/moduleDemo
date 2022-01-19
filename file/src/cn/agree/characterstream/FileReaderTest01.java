package cn.agree.characterstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) throws IOException {
        // 使用File对象创建流对象
        // File file = new File("E:/reader.txt");
        // FileReader fileReader1 = new FileReader(file);

        // 使用文件名称创建流对象
        FileReader fileReader2 = new FileReader("E:/reader.txt");
        // 定义变量,保存数据
        int b;
        // 循环读取
        while ((b = fileReader2.read()) != -1) {
            System.out.println((char) b);
        }

        // 关闭资源
        fileReader2.close();

        System.out.println("---------------------");
        FileReader fileReader3 = new FileReader("E:/reader.txt");
        int len;
        // 定义字符数组,作为装字符数据的容器
        char[] cbuf = new char[3];

        while ((len = fileReader3.read(cbuf)) != -1) {
            System.out.println(new String(cbuf, 0, len));
        }

        // 关闭资源
        fileReader3.close();

    }
}
