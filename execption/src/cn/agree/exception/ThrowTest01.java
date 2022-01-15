package cn.agree.exception;

public class ThrowTest01 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 52, 2};
        int index = 4;
        int element = getElement(arr, index);
    }

    public static int getElement(int[] arr, int index) {
        if (index<0 || index>arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException("兄弟,越界了~~~");
        }

        int element = arr[index];
        return element;
    }
}
