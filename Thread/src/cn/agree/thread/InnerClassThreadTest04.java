package cn.agree.thread;

public class InnerClassThreadTest04 {
    public static void main(String[] args) {
        /*
        *  开启一个新的线程
        *
        * */
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 90; i++) {
                    System.out.println("打印一百遍:" + i);
                }
            }
        }).start();

        /*
        *  主线程执行
        * */
        for (int i = 0; i < 90; i++) {
            System.out.println("主线程走起:"+ i);
        }


    }
}
