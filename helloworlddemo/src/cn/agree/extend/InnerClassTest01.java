package cn.agree.extend;

import cn.agree.pojo.InnerClassPerson;

public class InnerClassTest01 {
    public static void main(String[] args) {
        InnerClassPerson innerClassPerson = new InnerClassPerson(true);
        // 原来内部类也是需要new的
        InnerClassPerson.Heart heart = innerClassPerson.new Heart();

        heart.jump();
        innerClassPerson.setLive(false);
        heart.jump();

    }
}
