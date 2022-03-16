package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "servlet01", urlPatterns = "/serv01")
public class servlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取用户当前访问时间
        Date date = new Date();
        // 格式化时间数据
        // cookie值中不能有分号,逗号,等号以及空格
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日,=hh:mm:ss");
        String format1 = format.format(date);
        System.out.println(format1);

        // 如果有特殊符号,将它们进行编码
        String encode = URLEncoder.encode(format1, "utf-8");
        // 创建一个cookie
        Cookie cookie = new Cookie("time", encode);
        cookie.setMaxAge(60*60);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        cookie.setPath(contextPath);
        // 将数据发送给浏览器
        resp.addCookie(cookie);

        // 第二次访问操作
        Cookie[] cookies = req.getCookies();
        if (cookie !=null) {
            for (Cookie cookie1 : cookies) {
                if ("time".equals(cookie1.getName())) {
                    // 之前的数据是经过编码的,现在需要经过解码才可以用
                    String decode = URLDecoder.decode(cookie1.getValue(), "utf-8");
                    resp.setContentType("text/html;charset=utf-8");
                    resp.getWriter().write(decode);
                }
            }
        }

    }
}
