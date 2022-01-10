package cn.agree.pojo;

public class InnerClassPerson {

    private boolean live = true;

    public class Heart{
        public void jump() {
            // 直接访问外部成员
            if (live) {
                System.out.println("心脏一直在跳动");
            } else {
                System.out.println("不行了不行了,心脏不跳动了");
            }
        }
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public InnerClassPerson(boolean live) {
        this.live = live;
    }
}
