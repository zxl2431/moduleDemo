package cn.agree.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPictureTest01 {
    public static void main(String[] args) throws IOException {
        // 1.创建流对象
        // 1.1 指定数据源
        FileInputStream fis = new FileInputStream("E:/test.jpg");
        // 1.2 指定目的地
        FileOutputStream fos = new FileOutputStream("E:/test_copy.jpg");

        // 2.读取数据
        // 2.1 定义数组
        byte[] bytes = new byte[1024];
        // 2.2 定义长度
        int len;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        // 3.关闭资源
        fos.close();
        fis.close();
    }
}
