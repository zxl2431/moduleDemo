package cn.agree.lambda;

public class CalculatorTest01 {
    public static void main(String[] args) {
        invokeCalc(10, 20, (int a, int b) -> {
            return a+b;
        });
    }

    private static void invokeCalc(int a, int b, Caculator caculator) {
        int result = caculator.calc(a, b);
        System.out.println("结果是: " + result);
    }
}
