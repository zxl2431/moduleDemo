package cn.agree.map;

import cn.agree.polo.Student;

import java.util.HashMap;
import java.util.Set;

public class MapTest02 {
    public static void main(String[] args) {
        HashMap<Student, String> studentStringHashMap = new HashMap<>();
        studentStringHashMap.put(new Student("lisi", 16), "上海");
        studentStringHashMap.put(new Student("liwu", 17), "北京");
        studentStringHashMap.put(new Student("liliu", 18), "天津");
        studentStringHashMap.put(new Student("liqi", 19), "南京");

        Set<Student> students = studentStringHashMap.keySet();
        for (Student stu : students) {
            String str = studentStringHashMap.get(stu);
            System.out.println(stu.toString() + "---" + str);
        }

    }
}
