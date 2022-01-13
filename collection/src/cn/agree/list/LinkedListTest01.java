package cn.agree.list;

import java.util.LinkedList;

public class LinkedListTest01 {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();
        // 添加元素
        link.addFirst("Mr.Zhang1");
        link.addFirst("Mr.Zhang2");
        link.addFirst("Mr.Zhang3");
        link.addFirst("Mr.Zhang4");
        System.out.println(link);
        System.out.println("---------------");
        // 获取元素
        System.out.println(link.getFirst());
        System.out.println(link.getLast());
        // 删除元素
        System.out.println(link.removeFirst());
        System.out.println(link.removeLast());

        System.out.println("--------------");
        while (!link.isEmpty()) {
            System.out.println(link.pop());
        }

        System.out.println("---------------");
        System.out.println(link);
    }
}
