package cn.agree.system;

import java.util.Date;

public class SystemTest01 {
    public static void main(String[] args) {
        /*
        *  获取当前时间和1970年01/01之间的毫秒插值
        *  currentTimeMillis
        * */
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date.getTime());


        /*
        *  数组拷贝
        *  arraycopy
        *
        * */
        int[] src = new int[]{1,2,3,4,5};
        int[] dest = new int[]{6,7,8,9,10};
        System.arraycopy( src, 0, dest, 0, 3);
        /*代码运行后：两个数组中的元素发生了变化 src数组元素[1,2,3,4,5] dest数组元素[1,2,3,9,10] */
        System.out.println(src.toString());

    }
}
