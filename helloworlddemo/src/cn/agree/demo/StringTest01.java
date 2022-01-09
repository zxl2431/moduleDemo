package cn.agree.demo;

public class StringTest01 {
    public static void main(String[] args) {

        // 内存中有 abc和abcd两个对象
        String str1 = "abc";
        str1 += "d";
        System.out.println(str1);

        // "Mr.zhang"在内存中被str2和str3共享
        String str2 = "Mr.zhang";
        String str3 = "Mr.zhang";

        // string 等效于char[]
        char[] cha = {'x', 'y', 'z'};
        String str4 = new String(cha);
        String str5 = "xyz";
        System.out.println(str4);

        // String的常用方法
        // 获取字符串长度 length()
        System.out.println(str5.length());
        /*
        *  concat(String str)
        *  字符串拼接
        * */
        String str6 = str5.concat("abc");
        System.out.println(str6);

        /*
        *  返回指定索引处的char值
        * charAt(int index)
        * */
        char cha0 = str6.charAt(0);
        System.out.println(cha0);

        /*
        *  返回指定字符串第一次出现的位置
        *  indexOf(String str)
        * */
        System.out.println(str6.indexOf("zab"));

        /*
        *  截取字符串
        *  substring(int beginIndex) 截取到最后
        *  substring(int beginIndex, int endIndex)
        * */
        String str7 = str6.substring(2);
        System.out.println(str7);
    }
}
