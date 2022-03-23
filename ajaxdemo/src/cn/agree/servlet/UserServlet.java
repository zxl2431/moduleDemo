package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isExist = true;
        String username = req.getParameter("username");
        if (!"haohao".equalsIgnoreCase(username)) {
            isExist = false;
        }

        // 回写状态爱
        String json = "{\"isExist\":"+isExist+"}";
        resp.getWriter().write(json);
    }
}
