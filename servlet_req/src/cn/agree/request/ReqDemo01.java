package cn.agree.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReqDemo01", urlPatterns = "/req01")
public class ReqDemo01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求方式类型
        String method = req.getMethod();
        System.out.println("获取请求方式的类型:"+method);

        // 2. 获取请求行中资源名部分
        String requestURI = req.getRequestURI();
        System.out.println("获取请求行中资源名部分:"+requestURI);

        // 3.获取客户端发出请求完整URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("获取客户端发出请求完整URL:"+requestURL);

        // 4. 获取当前协议的名称和版本
        String protocol = req.getProtocol();
        System.out.println("获取当前协议的名称和版本:"+protocol);

        // 5.获取IP地址
        String remoteAddr = req.getRemoteAddr();
        System.out.println("获取IP地址:"+remoteAddr);
    }
}
