package cn.agree.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "ReqDemo02", urlPatterns = "/req02")
public class ReqDemo02 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 以String的形式指定请求头的值
        String header = req.getHeader("User-Agent");
        System.out.println("getHeader:"+header);

        // 返回请求中包含的所有头名称的枚举
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println("getHeaderNames:"+headerNames.nextElement());
        }
    }
}
