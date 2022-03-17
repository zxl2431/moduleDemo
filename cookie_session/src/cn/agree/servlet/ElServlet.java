package cn.agree.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ElServlet", urlPatterns = "/el")
public class ElServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req域中存放一个数组
        int[] arr = {11,22,33,44,55};
        req.setAttribute("arr", arr);

        // list集合
        List list = new ArrayList();
        list.add("北京传智播客");
        list.add("上海传智播客");
        list.add("广州传智播客");
        req.setAttribute("list",list);
        // map集合
        Map map = new HashMap();
        map.put("language1", "php");
        map.put("language2", "go");
        map.put("language3", "c#");
        map.put("aa.bb.cc", "python");
        req.setAttribute("map",map);

        req.getRequestDispatcher("/4.jsp").forward(req, resp);
    }
}
