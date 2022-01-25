package cn.agree.test;

import cn.agree.interfac.Sumable;

public class SumableTest01 {
    public static void main(String[] args) {
        showSum(5,6, (m,n) -> m+n);
        showSum(5, 6, (m,n) -> m*n);
        showSum(10, 2, new Sumable() {
            @Override
            public int sum(int a, int b) {
                return a / b;
            }
        });
    }

    public static void showSum(int x, int y, Sumable sumCalculator) {
        System.out.println(sumCalculator.sum(x, y));
    }
}
