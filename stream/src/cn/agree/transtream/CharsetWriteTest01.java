package cn.agree.transtream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CharsetWriteTest01 {
    public static void main(String[] args) throws IOException {
        // 定义文件路径
        String FileName = "E:/out1.txt";
        // 创建流对象 默认的是UTF-8
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(FileName));
        // 写数据
        osw.write("你好");    // 保存为6个字节
        osw.close();


        // 定义文件路径
        String FileName2 = "E:/out2.txt";
        OutputStreamWriter osw2 = new OutputStreamWriter(new FileOutputStream(FileName2), "GBK");
        // 写出数据
        osw2.write("你好");   // 保存为4个字节
        osw2.close();


    }
}
