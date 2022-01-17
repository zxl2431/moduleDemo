package cn.agree.file;

import java.io.File;

public class FileFor {
    public static void main(String[] args) {
        File dir = new File("D:/java_module");

        // 获取当前目录下的文件以及文件夹
        String[] list = dir.list();

        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("----------------");
        // 获取当前目录下的文件以及文件夹对象,只要拿到了文件对象,那么就可以获取更多信息
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
