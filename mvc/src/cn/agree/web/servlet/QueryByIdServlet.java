package cn.agree.web.servlet;

import cn.agree.domain.Contact;
import cn.agree.service.ContactService;
import cn.agree.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QueryByIdServlet", urlPatterns = "/queryById")
public class QueryByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数id
        int id = Integer.parseInt(req.getParameter("id"));
        //调用service方法获取数据
        ContactService contactService = new ContactServiceImpl();
        Contact con = contactService.queryById(id);
        //将数据转发到页面展示
        req.setAttribute("con",con);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }
}
