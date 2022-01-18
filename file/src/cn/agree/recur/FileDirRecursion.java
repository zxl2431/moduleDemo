package cn.agree.recur;

import java.io.File;

public class FileDirRecursion {
    public static void main(String[] args) {
        File file = new File("D:/java_module");
        printDir(file);
    }

    public static void printDir(File dir) {
        File[] files = dir.listFiles();
        /*
        *  是文件的时候,打印绝对路径
        *  是文件夹的时候,继续调用打印目录的方法
        *
        * */
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                System.out.println("目录:" + file.getAbsolutePath());
                printDir(file);
            }
        }
    }
}
