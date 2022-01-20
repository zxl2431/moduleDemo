package cn.agree.bytestream;

import java.io.*;

public class BufferedDemoTest02 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try (
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:/tomcat.zip"));
                BufferedOutputStream bos =  new BufferedOutputStream(new FileOutputStream("E:/tomcat_copy2.zip"))

        ){
            //
            int len;
            byte[] bytes = new byte[8*1024];

            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("缓冲流复制时间:"+(end - start) + "毫秒");
    }
}
