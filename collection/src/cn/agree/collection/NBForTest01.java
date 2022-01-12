package cn.agree.collection;

import java.util.ArrayList;
import java.util.Collection;

public class NBForTest01 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        for (int a : arr) {
            System.out.println(a);
        }

        Collection<String> coll = new ArrayList<>();
        coll.add("串串星人");
        coll.add("吐槽星人");
        coll.add("汪星人");
        for (String s : coll) {
            System.out.println(s);
        }

        // for (int i=0; i<coll.size(); i++) {
        //     System.out.println(coll.);
        // }
    }
}
