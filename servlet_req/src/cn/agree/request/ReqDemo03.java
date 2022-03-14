package cn.agree.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ReqDemo03", urlPatterns = "/req03")
public class ReqDemo03 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        // 获取请求头的referer
        String referer = req.getHeader("referer");
        System.out.println(referer);

        if ("http://localhost:8080/download.html".equals(referer)) {
            // 没有盗链
            writer.write("可以下载");
        } else {
            writer.write("只是盗链不可以下载");
        }

        writer.flush();
        writer.close();
    }
}
