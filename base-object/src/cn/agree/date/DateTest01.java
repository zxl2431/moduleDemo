package cn.agree.date;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        // 创建日期对象,
        // println方法是,会自动调用Date中的toString方法
        System.out.println(new Date());
        System.out.println(new Date().toString());

        // 创建日期对象 把当前的毫秒值转成日期
        // 计算机科学里的时间是从 1970年1月1日八点开始的
        System.out.println(new Date(0L));
    }
}
