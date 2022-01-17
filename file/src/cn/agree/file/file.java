package cn.agree.file;

import java.io.File;

public class file {
    public static void main(String[] args) {
        /*
        *  1、一个File对象代表硬盘中实际存在的一个文件或者目录
        *  2、无论该路径下是否存在文件或者目录 都不影响File对象的创建
        *
        * */

        // 文件路径名
        String pathname1 = "E:\\a1.txt";
        File file = new File(pathname1);
        
        // 文件路径名
        String pathname2 = "E:\\a\\b1.txt";
        File file2 = new File(pathname2);
        
        // 通过父路径和子路劲字符串
        String parent = "E:\\a";
        String child = "b2.txt";
        File file3 = new File(parent, child);
        
        // 通过父级File对象和子路径字符串
        File file4 = new File("E:\\a");
        String child1 = "b3.txt";
        File file5 = new File(file4, child1);


    }
}
