package cn.agree.demo;

public class StringTest02 {
    public static void main(String[] args) {
        /*
        *  将字符串转换成新的字节数组
        *  public char[] toCharArray()
        * */
        String str1 = "abcde";
        char[] charArray1 = str1.toCharArray();
        System.out.println(str1);
        // System.out.println(charArray1);
        // for (int i = 0; i < charArray1.length; i++) {
        //     System.out.println(charArray1[i]);
        // }

        /*
        * 使用平台的默认字符集将该string编码转换为新的字节数组
        * public byte[] getBytes()
        *
        * */
        byte[] bytes1 = str1.getBytes();
        // System.out.println(bytes1);
        for (int i = 0; i < bytes1.length; i++) {
            System.out.println(bytes1[i]);
        }

        /*
        *  将与target匹配的字符串用replacement字符代替
        *  public String replace (CharSequence target, CharSequence replacement)
        *
        * */
        String str2 = "nihao, worldJava";
        String replace = str2.replace("nihao", "Hello");
        System.out.println(replace);

        /*
        *  将字符串按照给定的regex规则拆分成字符串数组
        *  `public String[] split(String regex)`
        * */
        String str3 = "aa,bb,cc";
        String[] split = str3.split(",");
        System.out.println(split);
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }


    }
}
