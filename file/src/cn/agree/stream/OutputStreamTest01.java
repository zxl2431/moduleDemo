package cn.agree.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamTest01 {
    public static void main(String[] args) throws IOException {
        // 使用File对象创建流对象
        File file = new File("E:/a.txt");
        FileOutputStream fos1 = new FileOutputStream(file, true);
        fos1.write(97);
        fos1.write(98);
        fos1.write(99);
        fos1.write(100);

        byte[] bytes = "这字符串变字节数组不要太简单".getBytes();
        fos1.write(bytes);
        byte[] bytes1 = "wxyzh".getBytes();
        fos1.write(bytes1, 2, 2);
        byte[] bytes2 = "\r\n".getBytes();
        fos1.write(bytes2);
        fos1.close();


        // 使用文件名称创建流对象
        FileOutputStream fos2 = new FileOutputStream("E:/b.txt");

        /*
        *  如果想要file追加写
        *  new的时候 构造方法有个true
        *
        * */

    }
}
