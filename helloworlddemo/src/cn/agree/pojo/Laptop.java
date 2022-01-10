package cn.agree.pojo;

import cn.agree.inter.USB;

public class Laptop {
    public void run() {
        System.out.println("笔记本运行");
    }

    // 笔记本使用
    public void useUSB(USB usb) {
      if (usb != null) {
          usb.open();
          if (usb instanceof Mouse) {
              Mouse m = (Mouse) usb;
              m.click();
          } else if( usb instanceof KeyBoard) {
              KeyBoard kb = (KeyBoard) usb;
              kb.type();
          }
          usb.close();
      }
    }

    //
    public void shutDown() {
        System.out.println("笔记本关机");
    }
}
