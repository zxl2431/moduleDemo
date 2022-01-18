package cn.agree.recur;

import java.io.File;

public class FileFilter {
    public static void main(String[] args) {
        File file = new File("D:/java_module");
        // printDir2(file);
        printDir3(file);
    }

    public static void printDir2(File dir) {
        File[] files = dir.listFiles(new java.io.FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java") || pathname.isDirectory();
            }
        });

        // 循环打印
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                printDir2(file);
            }
        }
    }

    public static void printDir3(File dir) {
        File[] files = dir.listFiles(f -> {
            return f.getName().endsWith(".java") || f.isDirectory();
        });

        // 循环打印
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                printDir2(file);
            }
        }

    }

}
