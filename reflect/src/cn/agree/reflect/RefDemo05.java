package cn.agree.reflect;

import cn.agree.pojo.Student;

import java.lang.reflect.Field;


/*
*  获取Class对象的Field信息
*
* */
public class RefDemo05 {
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class c = Student.class;
        // 快速创建一个学生对象
        Student stu = (Student) c.newInstance();

        // 获得public修饰Field对象
        Field f1 = c.getField("gender");
        f1.set(stu, "风清扬");
        String gender = (String) f1.get(stu);
        System.out.println("性别:"+gender);

        // 获取private修饰Field对象
        Field f2 = c.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(stu, 30);
        System.out.println("年龄:"+stu.getAge());

        System.out.println("-------获得所有public修饰的属性--------");
        Field[] fs1 = c.getFields();
        // 遍历数组
        for (Field f: fs1) {
            System.out.println(f);
        }

        System.out.println("-------获得所有的属性，包括private修饰--------");
        // 获得所有的属性，包括private修饰
        Field[] fs2 = c.getDeclaredFields();
        // 遍历数组
        for(Field f : fs2) {
            System.out.println(f);
        }
    }
}
