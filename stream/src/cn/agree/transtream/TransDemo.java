package cn.agree.transtream;

import java.io.*;

public class TransDemo {
    public static void main(String[] args) throws IOException {
        // 1.定义文件路径
        String srcFile = "E:/file_gbk.txt";
        String destFile = "E:/file_utf8.txt";

        // 2. 创建流对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destFile));

        // 3.读写数据
        // 3.1 定义数组
        char[] cbuf = new char[1024];
        // 3.2 定义长度
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        // 4.释放资源
        osw.close();
        isr.close();

    }
}
