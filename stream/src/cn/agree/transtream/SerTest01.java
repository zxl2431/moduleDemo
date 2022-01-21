package cn.agree.transtream;

import java.io.*;
import java.util.ArrayList;

public class SerTest01 {
    public static void main(String[] args) throws Exception {
        Student stu1 = new Student("Mr.Zhang", 18);
        Student stu2 = new Student("Mr.Yi", 16);
        Student stu3 = new Student("Mr.An", 1);

        ArrayList<Student> stuList = new ArrayList<>();
        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);

        // 序列化操作
        serializ(stuList);

        // 反序列化操作
        reSerializ();



    }

    // 序列化操作
    public static void serializ(ArrayList<Student> arrayList) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/list.txt"));
        // 写出对象
        oos.writeObject(arrayList);
        oos.close();
    }

    // 反序列化操作
    public static void reSerializ() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/list.txt"));
        // 读取对象文件
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject();

        ois.close();

        for (int i=0; i<list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student);
        }
    }

}
