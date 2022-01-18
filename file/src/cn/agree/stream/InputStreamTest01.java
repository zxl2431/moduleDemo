package cn.agree.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamTest01 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/a.txt");
        FileInputStream fis1 = new FileInputStream(file);

        int read = fis1.read();
        System.out.println( read);
    }
}
