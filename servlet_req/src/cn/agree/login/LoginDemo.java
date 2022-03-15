package cn.agree.login;

import cn.agree.dao.UserDaoImpl;
import cn.agree.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginDemo", urlPatterns = "/log")
public class LoginDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 收到请求
        System.out.println("LoginDemo收到请求");
        Map<String, String[]> map = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("收到的数据user:"+user);
        UserDaoImpl userDao = new UserDaoImpl();
        User user1 = userDao.findUser(user);
        System.out.println("查询出来的数据:"+user1);

        resp.setContentType("text/html;charset=utf-8");
        if (user1 != null) {
            resp.getWriter().write("登录成功");
        } else{
            resp.getWriter().write("登录失败");
        }


    }
}
