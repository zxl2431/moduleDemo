package cn.agree.file;

import java.io.File;
import java.io.IOException;

public class FileCURD {
    public static void main(String[] args) throws IOException {
        /*
         *  创建删除功能的方法
         *  boolean createNewFile() 当且仅当具有该名称的文件尚不存在时,创建一个新的空文件
         *  boolean delete() 删除由此File表示的文件或目录
         *  boolean mkdir() 创建由此File表示的目录
         *  boolean mkdirs() 创建有此File表示的目录,包括任何必须但不存的父目录
         *
         * */

        // 文件的创建
        File file1 = new File("E:/bbb.txt");
        System.out.println("是否存在:" + file1.exists());
        System.out.println("是否创建:" + file1.createNewFile());
        System.out.println("是否存在:" + file1.exists());

        // 目录的创建
        File file2 = new File("E:/newDir");
        System.out.println("是否存在:" + file2.exists());
        System.out.println("是否创建:" + file2.mkdir());
        System.out.println("是否存在:" + file2.exists());

        // 创建多级目录
        File file3 = new File("E:/newDir2/newDir3");
        System.out.println(file3.mkdir());
        File file4 = new File("E:/newDir2/newDir4");
        System.out.println(file4.mkdirs());

        // 文件删除
        // System.out.println(file1.delete());
        //         // System.out.println(file2.delete());
    }
}
