package cn.agree.calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        // Calendar创建的时候不在是new 而是getInstance()
        Calendar calendar = Calendar.getInstance();
        /*
        *  常用方法
        *  1, 返回给定日历字段值 get(int field)
        *  2, 给定的字段设置值 set(int field, int value)
        *  3, 根据日历规则,为给定的日历字段添加或者减去指定的时间量 add(int field, int amount)
        *  4, 返回一个表示此Calendar时间值的Date对象 getTime()
        * */
        // 设置值
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 3);
        calendar.set(Calendar.DAY_OF_MONTH, 22);

        // 加10天
        calendar.add(Calendar.DAY_OF_MONTH, 10);

        // 获取值
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(year);
        System.out.println(month);
        System.out.println(date);
        // System.out.println(dayOfWeek);

        // Calendar中的getTime() 是拿到对应的Date对象
        // 和Date中的getTime() 获取毫秒值是不一样的
        Date time = calendar.getTime();
        System.out.println(time);


    }
}
