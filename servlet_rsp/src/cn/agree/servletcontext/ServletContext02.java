package cn.agree.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContext02", urlPatterns = "/context2")
public class ServletContext02 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取容器
        ServletContext context = getServletContext();
        // 获取数据
        String addr = (String) context.getAttribute("addr");
        System.out.println("获取数据addr:"+ addr);
        context.removeAttribute("addr");
        //重新获取数据
        String addr2 = (String) context.getAttribute("addr");
        System.out.println("移除之后,获取数据:"+addr2);
    }
}
