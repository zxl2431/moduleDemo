package cn.agree.annotation;

import java.lang.reflect.Method;
import java.util.Arrays;

/*
*  @author Mr.Zhang
*  @version 1.0
*
* */
public class AnnoDemo01 {
    public static void main(String[] args) throws Exception {
        System.out.println("---------获取类上注解的数据----------");
        test01();
        System.out.println("---------获取成员方法上注解的数据----------");
        test02();
    }

    /*
    *  获取类上注解的数据
    * */
    public static void test01() {
        Class c = BookShelf.class;
        Book book = (Book) c.getAnnotation(Book.class);
        // 输出book注解的属性
        System.out.println("书名：" + book.value());
        System.out.println("价格：" + book.price());
        System.out.println("作者: " + Arrays.toString(book.authors()));
    }

    /*
    *  获取成员方法上的注解数据
    *
    * */
    public static void test02() throws Exception {
         Class c = BookShelf.class;
         //获取成员方法
        Method m = c.getMethod("showBook");
        Book book = (Book) m.getAnnotation(Book.class);
        // 输出book注解属性值
        System.out.println("书名：" + book.value());
        System.out.println("价格：" + book.price());
        System.out.println("作者：" + Arrays.toString(book.authors()));
    }
}
