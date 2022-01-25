package cn.agree.test;

import java.util.function.Supplier;

public class SupplierTest01 {
    /*
    *  Supplier<T> 接口仅包含一个无参方法: T get()
    *  用来获取一个泛型参数指定类型的对象数据
    *
    *
    * */
    private static String getString(Supplier<String> function) {
        return function.get();
    }


    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = " ";
        String msgC = "World";
        System.out.println(getString(() -> msgA + msgB + msgC));
    }

}
