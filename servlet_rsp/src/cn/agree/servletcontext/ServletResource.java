package cn.agree.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebServlet(name = "ServletResource", urlPatterns = "/res01")
public class ServletResource extends HttpServlet{
    private static final long serivalVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取resource目录下的文件
        Properties properties = new Properties();
        // 将资源文件转化成流
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/druid.properties");
        System.out.println(realPath);

        InputStream is = new FileInputStream(realPath);
        properties.load(is);
        String username = properties.getProperty("username");
        System.out.println(username);

    }
}
