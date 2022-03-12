package cn.agree.bean;

import cn.agree.pojo.Student;
import cn.agree.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.JavaBean;
import java.lang.reflect.InvocationTargetException;

public class BeanDemo02 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        /*
        *  将一个JavaBean对象的属性赋值给另外一个JavaBean
        *
        * */
        Student stu = new Student();
        BeanUtils.setProperty(stu, "name", "张三");
        BeanUtils.setProperty(stu, "age", 18);
        BeanUtils.setProperty(stu, "gender", "girl");
        System.out.println(stu);

        Student stu2 = new Student();
        // 相同对象之间的赋值
        BeanUtils.copyProperties(stu2, stu);
        System.out.println(stu2);

        // 不同对象之间之后属性名才能赋值上
        User user = new User();
        BeanUtils.copyProperties(user, stu);
        System.out.println(user);

    }
}
