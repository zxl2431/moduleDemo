package cn.agree.recur;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        File file = new File("D:/java_module");
        search(file);
    }

    public static void search(File dir) {
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    System.out.println("文件名:" + file.getAbsolutePath());
                }
            } else {
                search(file);
            }
        }
    }
}
