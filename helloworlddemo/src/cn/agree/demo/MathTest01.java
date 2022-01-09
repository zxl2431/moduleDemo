package cn.agree.demo;

import java.rmi.MarshalException;

public class MathTest01 {
    public static void main(String[] args) {
        /*
        *  1.去绝对值 abs(double a)
        *  public static double abs(double a)
        *  2.向上取整 ceil(double a)
        *  3.向下取整floor(double a)
        *  4.四舍五入round(double a)
        * */
        System.out.println(Math.abs(-5));
        System.out.println(Math.ceil(-6.3));
        System.out.println(Math.floor(6.3));
        System.out.println(Math.round(4.45));

        System.out.println("------------");
        double min = -10.8;
        double max = 5.9;
        int count = 0;
        for (double i = Math.ceil(min); i<=max; i++) {
            if (Math.abs(i) > 6 || Math.abs(i)<2.1) {
                count++;
            }
        }

        System.out.println(count);

    }
}
