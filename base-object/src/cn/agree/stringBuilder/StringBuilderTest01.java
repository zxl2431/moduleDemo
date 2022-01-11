package cn.agree.stringBuilder;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        // 无参构造
        // StringBuilder sb1 = new StringBuilder();
        // 有参构造
        StringBuilder sb1 = new StringBuilder("Hello");
        System.out.println(sb1);
        sb1.append("world").append('C').append(true).append(100);
        System.out.println(sb1);
        String str1 = sb1.toString();
        System.out.println(str1);


    }
}
