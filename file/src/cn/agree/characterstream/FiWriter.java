package cn.agree.characterstream;

import java.io.FileWriter;
import java.io.IOException;

public class FiWriter {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("E:/reader.txt", true);
        // 写出数据
        fileWriter.write(97); // 写出第1个字符
        fileWriter.write('b'); // 写出第2个字符
        fileWriter.write('C'); // 写出第3个字符
        fileWriter.write(30000); // 写出第4个字符，中文编码表中30000对应一个汉字。

        /*
        *  因为内置缓冲区的原因
        *  如果不关闭输出流,无法写出字符到文件中,但是关闭的流对象
        *  是无法继续写出数据的,又想写出数据,又想继续使用流, 就需要
        *  使用flush方法了
        *
        * */
        fileWriter.close();


    }
}
