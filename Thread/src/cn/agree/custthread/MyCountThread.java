package cn.agree.custthread;

public class MyCountThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0  ) {
                System.out.println("------"+ i);
            }
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new MyCountThread().start();
    }
}
