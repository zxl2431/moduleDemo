package cn.agree.request;

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

@WebServlet(name = "ReqDemoLogin05", urlPatterns = "/login")
public class ReqDemoLogin05 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        // 获取项目路径
        String contextPath = req.getContextPath();
        System.out.println("项目路径:"+contextPath);
        // 请求的参数map
        Map<String, String[]> map = req.getParameterMap();
        // 要封装的数据对象
        User user = new User();

        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }
}
