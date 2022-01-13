package cn.agree.collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsTest01 {
    public static void main(String[] args) {
        /*
        *  Collections 是集合的工具类,用来对集合进行操作
        *  常用方法如下
        * */
        ArrayList<Integer> list = new ArrayList<>();

        /*
        *  1. public static <T> boolean addAll(Collection<? super T> c, T... elements)
         *  往集合里面添加一些元素
        *
        * */
        Collections.addAll(list, 5, 222, 1, 2);
        System.out.println(list);

        /*
        *  2. shuffle(List<?> list)
        *
        *
        * */


        /*
        *  3. public static <T extends Comparable<? super T>> void sort(List<T> list)
        *   将集合的元素按照默认规则排序
        *
        * */
        Collections.sort(list);
        System.out.println(list);

        System.out.println("---------------------------");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("cba");
        list2.add("nba");
        list2.add("cuba");
        list2.add("abc");
        list2.add("bbc");
        System.out.println(list2);
        Collections.sort(list2);
        System.out.println(list2);

        /*
        *  4. void sort(List<T> list, Comparator<? super T>)
        *  将集合元素按照指定规则排序
        *
        *  这里重点是Comparable 和 Comparator两个皆苦的区别
        *
        * */
        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.charAt(0) - o1.charAt(0);
            }
        });

        System.out.println(list2);


    }
}
