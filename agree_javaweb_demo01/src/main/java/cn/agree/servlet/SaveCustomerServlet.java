package cn.agree.servlet;

import cn.agree.pojo.Customer;
import cn.agree.service.CustomerService;
import cn.agree.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveCustomerServlet", urlPatterns = "/SaveCustomer")
public class SaveCustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        req.setCharacterEncoding("utf-8");
        String custName = req.getParameter("cust_name");
        String custSource = req.getParameter("cust_source");
        String custLevel = req.getParameter("cust_level");
        String custIndustry = req.getParameter("cust_industry");
        String custAddress = req.getParameter("cust_address");
        String custPhone = req.getParameter("cust_phone");


        //封装数据
        Customer customer = new Customer();
        customer.setCust_name(custName);
        customer.setCust_source(custSource);
        customer.setCust_level(custLevel);
        customer.setCust_industry(custIndustry);
        customer.setCust_address(custAddress);
        customer.setCust_phone(custPhone);

        System.out.println("SaveCustomerServlet接受参数:"+customer);

        //调用业务
        customerService.save(customer);

        //重定向
        resp.sendRedirect(req.getContextPath()+"/success.jsp");
    }
}
