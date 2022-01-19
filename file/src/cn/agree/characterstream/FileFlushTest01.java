package cn.agree.characterstream;

import java.io.FileWriter;
import java.io.IOException;

public class FileFlushTest01 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("E:/reader.txt", true);
        // 写出数据 通过flush
        fileWriter.write('刷');
        fileWriter.flush();
        fileWriter.write('新');
        fileWriter.flush();

        char[] chars = "那还好".toCharArray();
        fileWriter.write(chars);

        fileWriter.write('关');
        // fileWriter.close();
        fileWriter.write('关');
        fileWriter.close();
    }
}
