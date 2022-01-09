package cn.agree.demo;

import java.util.Arrays;

public class ArraysTest01 {
    public static void main(String[] args) {
        /*
        *  1, 返回指定数组内容的字符串表示形式
        *  public static String toString(int[] a)
        * */
        int[] arr1 = {2,34,35,4,657,8,69,9};
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));

        /*
        *  2, 对int类型的数组进行升序排序
        *  pubilc static void sort(int[] a)
        *
        * */
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        /*
        *
        *
        * */
        String str1 = "ysKUreaytWTRHsgFdSAoidq";
        char[] charArray1 = str1.toCharArray();
        Arrays.sort(charArray1);
        System.out.println(Arrays.toString(charArray1));
    }
}
