package cn.agree.extend;

import cn.agree.pojo.KeyBoard;
import cn.agree.pojo.Laptop;
import cn.agree.pojo.Mouse;

public class LaptopTest01 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        Mouse mouse = new Mouse();
        KeyBoard keyBoard = new KeyBoard();
        laptop.useUSB(mouse);
        laptop.useUSB(keyBoard);
    }
}
