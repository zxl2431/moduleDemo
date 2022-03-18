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

@WebServlet(name = "UpdateServlet", urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入UpdateServlet");
        //处理请求参数乱码
        req.setCharacterEncoding("utf-8");
        //获取请求参数封装数据到对象
        Contact contact = new Contact();
        try {
            BeanUtils.populate(contact,req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用service方法修改数据
        ContactService contactService = new ContactServiceImpl();
        System.out.println(contact);
        contactService.update(contact);
        //调用查询全部的servlet，展示修改效果
        resp.sendRedirect(req.getContextPath()+"/queryAll");

    }
}
