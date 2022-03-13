package cn.agree.rsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Rsp02_Redirect", urlPatterns = "/redirect")
public class Rsp02_Redirect extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置重定向响应头
        // resp.setHeader("location", "http://www.taobao.com");
        // 设置状态码
        // resp.setStatus(302);
        /*
        *  上面代码的简化形式
        * */
        resp.sendRedirect("http://www.taobao.com");
    }
}
