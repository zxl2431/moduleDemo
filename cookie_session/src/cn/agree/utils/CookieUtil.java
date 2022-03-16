package cn.agree.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
    /*
    *  创建并配置cookie
    *  name-value
    *  time
    *  path
    *
    * */
    public static Cookie createCookie(String name, String value, int time, String path) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(time);
        cookie.setPath(path); // 只能在哪个servlet中获取该cookie的信息
        return cookie;
    }

    public static String getCookieValue(HttpServletRequest req, String cookieName) {
        Cookie[] cookies = req.getCookies();
        String value = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    value = cookie.getValue();
                }
            }
        }

        return value;
    }

}
