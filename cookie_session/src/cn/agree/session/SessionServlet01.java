package cn.agree.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "SessionServlet01", urlPatterns = "/sess01")
public class SessionServlet01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("sess01获取的session"+session);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        // 时间长一点
        cookie.setMaxAge(60*60);
        session.setAttribute("addr", "广州");
        resp.addCookie(cookie);
    }

}
