package cn.agree.customexception;

public class LoginException extends Exception {
    /*
    *  空构造
    *
    * */
    public LoginException() {
    }

    /*
    *  @param message 表示异常提示
    * */
    public LoginException(String message) {
        super(message);
    }
}
