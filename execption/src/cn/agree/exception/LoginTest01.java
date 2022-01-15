package cn.agree.exception;

import cn.agree.customexception.LoginException;

public class LoginTest01 {
    // 数据库中已有的账号
    private static String[] names = {"abc","cba", "nba"};

    public static void main(String[] args) {
        try {

            System.out.println(checkUserName("lili"));
            System.out.println("后面还来不?");
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserName(String uname) throws LoginException {
        for (String name: names) {
            if (uname.equals(name)) {
                throw new LoginException("名字已经存在!再想一个");
            }
        }

        return true;
    }
}
