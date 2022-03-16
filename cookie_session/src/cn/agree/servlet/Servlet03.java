package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Servlet03", urlPatterns = "/pic")
public class Servlet03 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        // 处理响应乱码
        resp.setContentType("text/html;charset=utf-8");
        if("1".equals(param)) {
            resp.getWriter().write("<h1><font color='red'>西施</font></h1>");
        }else if("2".equals(param)) {
            resp.getWriter().write("<h1><font color='red'>貂蝉</font></h1>");
        }else if("3".equals(param)) {
            resp.getWriter().write("<h1><font color='red'>王昭君</font></h1>");
        }else {
            resp.getWriter().write("参数不合法");
        }
    }
}
