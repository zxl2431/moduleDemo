package cn.agree.stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest03 {
    public static void main(String[] args) {
        String[] array =  { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        List<String> strings = pre(array, s -> s.split(",")[0].length() == 4, s -> s.split(",")[1].equals("男"));
        System.out.println(strings);

    }

    private static List<String> pre(String[] arr, Predicate<String> one, Predicate<String> two){
        List<String> list = new ArrayList<>();
        for (String info: arr) {
            if(one.and(two).test(info)) {
                list.add(info);
            }
        }

        return list;
    }
}
