package cn.agree.transtream;


import java.io.*;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee emp = new Employee("Mr.zhang", "湖北", 18);

        try {
            // 创建序列化流对象
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/employee.txt"));
            oos.writeObject(emp);
            oos.close();

            // 创建反序列化流
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/employee.txt"));
            // 读取一个对象
            Employee emp1 = (Employee) ois.readObject();
            // 释放资源
            ois.close();

            System.out.println(emp1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
