package cn.agree.web.servlet;

import cn.agree.domain.Contact;
import cn.agree.service.ContactService;
import cn.agree.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入AddServlet");
        // 处理post请求乱码
        req.setCharacterEncoding("utf-8");
        // 获取参数
        Contact contact = new Contact();
        try {
            BeanUtils.populate(contact,req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        ContactService contactService = new ContactServiceImpl();
        contactService.add(contact);

        // 重定向
        resp.sendRedirect(req.getContextPath()+"/queryAll");


    }
}
