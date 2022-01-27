package cn.agree.stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

public class ForEachTest01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        // for (String name : list) {
        //     System.out.println(name);
        // }


        /*
        *  do what 做什么
        *  how to do 怎么做
        *  Lambda的目的是更加专注做什么
        *  循环只是做事件的方式 循环体里面的才是要做的什么
        *
        *
        * */
        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }

        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }

        // for (String name : shortList) {
        //     System.out.println(name);
        // }

        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
    }
}
