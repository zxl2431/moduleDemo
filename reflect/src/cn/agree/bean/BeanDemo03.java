package cn.agree.bean;

import cn.agree.pojo.Student;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class BeanDemo03 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        /*
        *  将一个Map集合的数据封装都一个JavaBean中
        *
        * */
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "李四");
        map.put("age", 8);
        map.put("gender", "女");
        // 创建学生对象
        Student student = new Student();
        BeanUtils.populate(student, map);
        System.out.println(student);
    }
}
