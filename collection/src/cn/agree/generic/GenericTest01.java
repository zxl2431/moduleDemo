package cn.agree.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericTest01 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<String>();
        /*
        *  集合可以存放任意对象,只要把对象放进去了
        *  它们就会被提升为Object类型, 在取出来使用的时候
        *  必须使用类型转换
        *
        * */
        coll.add("abc");
        coll.add("agree");
        // coll.add(5);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            System.out.println(next);
        }
    }
}
