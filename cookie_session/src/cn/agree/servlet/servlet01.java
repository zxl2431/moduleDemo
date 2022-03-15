package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "servlet01", urlPatterns = "/serv01")
public class servlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建一个cookie
        Cookie cookie = new Cookie("username", "tom");
        // 获取用户当前访问时间
        Date date = new Date();
        // 格式化时间数据

        cookie.setMaxAge(60*60);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        cookie.setPath(contextPath);
        resp.addCookie(cookie);

    }
}
