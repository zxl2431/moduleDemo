package cn.agree.recur;

public class RecurTest01 {
    public static void main(String[] args) {
        /*
        *  递归就是自己调用自己
        *  但一定要有出口
        *  像下面这样玩 一定会玩到栈溢出
        *
        * */
        // System.out.println("main");
        // main(args);

        int sum = getSum(100);
        System.out.println(sum);

    }


    public static int getSum(int num) {
        /*
        *  出口
        * */
        if(num == 1) {
            return 1;
        }

        /*
        *
        *
        * */
        return num + getSum(num -1);

    }
}
