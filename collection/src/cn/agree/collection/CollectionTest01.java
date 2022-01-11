package cn.agree.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest01 {
    public static void main(String[] args) {
        // 以多态的形式创建
        Collection<String> coll = new ArrayList<>();

        // add方法 添加元素
        coll.add("小李广");
        coll.add("扫地僧");
        coll.add("石破天");
        System.out.println(coll);

        // contains()方法看时否包含
        System.out.println(coll.contains("Mr.zhang"));
        System.out.println(coll.contains("小李广"));

        // remove()方法删除元素
        coll.remove("石破天");
        System.out.println(coll);

        // size()方法 集合中有的元素个数
        System.out.println(coll.size());

        // 转换成一个Object数组
        Object[] array = coll.toArray();
        System.out.println(array);

        // 清空集合 clear()

        // 查看集合是否为空 isEmpty()


    }
}
