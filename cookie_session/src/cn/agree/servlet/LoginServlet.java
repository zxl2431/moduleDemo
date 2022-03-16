package cn.agree.servlet;

import cn.agree.dao.UserDao;
import cn.agree.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取验证码
        String code = req.getParameter("code");
        System.out.println("LoginServlet得到的验证码:"+code);
        // session中的验证码
        String code_session = (String) req.getSession().getAttribute("code_session");

        // 判断是否相等
        if(!code_session.equalsIgnoreCase(code)) {
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("LoginServlet得到的用户名密码:"+name+"---"+password);

        User loginUser = UserDao.login(name, password);
        if (loginUser == null) {
            req.setAttribute("msg", "查无此人");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        } else {
            resp.sendRedirect(req.getContextPath());
            return;
        }

    }
}
