package cn.agree.bean;

import cn.agree.pojo.Student;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanDemo01 {
    public static void main(String[] args) throws Exception {
        Student stu = new Student();
        // 调佣BeanUtils工具类的方法给对象属性赋值
        BeanUtils.setProperty(stu, "name", "风清扬");
        BeanUtils.setProperty(stu,"gender","男");
        BeanUtils.setProperty(stu,"age",40);
        System.out.println(stu);

        // 调用BeanUtils工具类方法获取对象属性值
        String name = BeanUtils.getProperty(stu,"name");
        String gender = BeanUtils.getProperty(stu,"gender");
        String age = BeanUtils.getProperty(stu,"age");
        System.out.println("姓名："+ name);
        System.out.println("性别："+ gender);
        System.out.println("年龄：" + age);


    }
}
