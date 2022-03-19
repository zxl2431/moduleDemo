package cn.agree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "IllegalFilter", urlPatterns = "/IllegalServlet")
public class IllegalFilter implements Filter {
    // 声明一个集合用来保存非法字符库
    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 获取非法文字的文件的绝对路径
        String realPath = filterConfig.getServletContext().getRealPath("/WEB-INF/classes/IllegalWords.txt");
        System.out.println("IllegalFilter.init()真实路径:"+realPath);
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(realPath), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            // 将文件中的非法字符读取到内存中
            while ((line= br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("非法字符:"+list);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        //获取请求中的参数
        request.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");

        // 遍历所有的非法字符
        for (String word : list) {
            System.out.println(message+":"+word+"====索引:"+message.indexOf(word));
            if ((message.indexOf(word)) != -1) {
                response.getWriter().write("含有非法字符");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
