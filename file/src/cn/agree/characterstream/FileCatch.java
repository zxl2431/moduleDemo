package cn.agree.characterstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCatch {
    public static void main(String[] args) {
        // 声明变量
        FileWriter fw = null;

        try {
            fw = new FileWriter("E:/xxx.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
