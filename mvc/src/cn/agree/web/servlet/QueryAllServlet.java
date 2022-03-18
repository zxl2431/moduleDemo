package cn.agree.web.servlet;

import cn.agree.domain.Contact;
import cn.agree.service.impl.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryAllServlet", urlPatterns = "/queryAll")
public class QueryAllServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取联系人数据
        System.out.println("进入QueryAllServlet");
        ContactServiceImpl contactService = new ContactServiceImpl();
        List<Contact> contacts = contactService.queryAll();
        System.out.println(contacts);

        // 将联系人数据转发到页面展示
        req.setAttribute("list", contacts);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
        // 设置编码 防止乱码
        // resp.setContentType("text/html;charset=UTF-8");
        // 将联系人数据发送到页面
        // resp.getWriter().write(String.valueOf(contacts));
    }
}
