package cn.agree.test;

public class RunableDemo {
    public static void main(String[] args) {
        startThread(() -> System.out.println("线程任务执行了!"));
    }

    public static void startThread(Runnable task) {
        new Thread(task).start();
    }
}
