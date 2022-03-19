package cn.agree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // req和resp进行墙砖
        System.out.println("EncodingFilter:"+servletRequest.getParameter("message"));
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        servletResponse.setContentType("text/html;charset=utf-8");
        // 获取请求方式
        String method = request.getMethod();
        if ("post".equalsIgnoreCase(method)) {
            request.setCharacterEncoding("utf-8");
            filterChain.doFilter(request, servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
