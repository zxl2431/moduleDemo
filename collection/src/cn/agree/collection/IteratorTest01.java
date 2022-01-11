package cn.agree.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest01 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("串串星人");
        coll.add("吐槽星人");
        coll.add("汪星人");
        Iterator<String> iterator = coll.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
