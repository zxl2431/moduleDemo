package cn.agree.file;

import java.io.File;

public class FileGet {
    public static void main(String[] args) {
        /*
        *  File的常用方法
        *  返回此File的绝对路径名的字符串
        *  public String getAbsolutePath()
        *  将此file转换为路径名 字符串
        *  public String getPath()
        *  getName()
        *  length() 此File表示的文件长度
        *
        * */
        File file1 = new File("E:/aaa/bbb.txt");
        System.out.println("文件绝对路径:" + file1.getAbsolutePath());
        System.out.println("文件构造路径:" + file1.getPath());
        System.out.println("文件名称" + file1.getName());
        System.out.println("文件长度" + file1.length() + "字节");
        System.out.println("------------");

        File file2 = new File("E:/aaa");
        System.out.println("目录绝对路径:" + file2.getAbsolutePath());
        System.out.println("目录构造路径" + file2.getPath());
        System.out.println("目录名称:" + file2.getName());
        System.out.println("目录长度:" + file2.length());

        File file3 = new File("bbb.java");
        System.out.println(file3.getAbsoluteFile());


        /*
        *  常用的判读方法
        *  exists()
        *  isDirectory()
        *  isFile()
        *
        * */
        System.out.println(file1.exists());
        System.out.println(file3.exists());

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());







    }
}
