package cn.agree.thread;

public class InnerClassThreadTest03 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 80; i++) {
                    System.out.println("Mr.Zhang: " + i);
                }
            }
        };

        new Thread(runnable).start();

        for (int i = 0; i < 80; i++) {
            System.out.println("Mr.Yi: " + i);
        }

    }
}
