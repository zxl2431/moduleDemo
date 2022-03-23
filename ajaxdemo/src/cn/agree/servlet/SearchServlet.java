package cn.agree.servlet;

import cn.agree.pojo.User01;
import cn.agree.service.SearchService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置中文乱码
        req.setCharacterEncoding("UTF-8");
        String word = req.getParameter("word");
        System.out.println("搜索的关键字:"+word);
        SearchService searchService = new SearchService();
        List<User01> search = searchService.search(word);
        System.out.println("查出来的list:"+search);
        // 转换成json 格式
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(search);
        // 设置中文乱码
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(json);


    }
}
