package cn.agree.lambda;

public class LambdaCookTest02 {
    public static void main(String[] args) {
        invokeCook(() -> {
            System.out.println("吃法啦");
        });
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
