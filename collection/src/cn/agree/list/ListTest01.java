package cn.agree.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        /*
        *  List集合的特点
        *  1.有序
        *  2.带索引
        *  3.可以重复
        *
        *
        * */
        List<String> list = new ArrayList<>();
        list.add("Mr.Zhang");
        list.add("Mrs.Yi");
        list.add("ZiAn");

        System.out.println(list);

        System.out.println(list.get(1));
        list.set(2, "Zi");
        System.out.println(list);
    }
}
