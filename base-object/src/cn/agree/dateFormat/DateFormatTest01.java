package cn.agree.dateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest01 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
        // System.out.println(format.toString());
        String str1 = format1.format(date);
        String str2 = format2.format(date);
        System.out.println(str1);
        System.out.println(str2);
        String str3 = "2022年01月12日";
        String str4 = "2022-01-13 22:50:02";
        Date parse1 = format2.parse(str3);
        Date parse2 = format1.parse(str4);
        System.out.println(parse1);
        System.out.println(parse2);
        System.out.println(parse1.getTime());


    }
}
