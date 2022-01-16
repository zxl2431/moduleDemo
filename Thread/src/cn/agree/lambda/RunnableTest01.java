package cn.agree.lambda;

public class RunnableTest01 {
    public static void main(String[] args) {
        Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("多线程执行!");
            }
        };

        // 启动线程
        new Thread(task).start();

    }
}
