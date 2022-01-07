package cn.agree.demo;

public class ArrayDemo1 {
    public static void main(String[] args) {
        int[] arr3 = {1, 2, 3, 4, 5};


        for (int i=0; i<arr3.length; i++) {
            System.out.print(arr3[i]);
        }

        arrReserve(arr3);
        System.out.println();

        for (int i=0; i<arr3.length; i++) {
            System.out.print(arr3[i]);
        }
    }

    /*
    *  数组翻转
    * */
    public static void arrReserve(int[] arr) {
        for (int min = 0, max = arr.length -1; min <= max; min++, max--) {
            int temp = arr[min];
            arr[min] = arr[max];
            arr[max] = temp;
        }
    }
}
