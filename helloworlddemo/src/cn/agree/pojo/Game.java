package cn.agree.pojo;

import java.util.ArrayList;

public class Game {
    public static int number;
    public static ArrayList<String> list;

    static {
        number = 2;
        list = new ArrayList<String>();
        // 添加元素
        list.add("Mr.zhang");
        list.add("Mrs.Yi");
        System.out.println(list);
    }

    public static void showGame() {
        System.out.println("-");
    }
}
