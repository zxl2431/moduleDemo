package cn.agree.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try (
                FileInputStream fis =  new FileInputStream("E:/tomcat.zip");
                FileOutputStream fos = new FileOutputStream("E:/tomcat_copy.zip")
                ){
            // 读写数据
            int len;
            while ((len = fis.read()) != -1) {
                fos.write(len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("普通流复制时间:"+(end - start)+ "毫秒");
    }
}
