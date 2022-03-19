package cn.agree.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebFilter(filterName = "FilterDemo01", urlPatterns = "/*")
public class FilterDemo01 implements Filter {

    /*
    *  Filter的生命周期
    *  1、服务启动的时候过滤器被初始化,执行过滤器的init()方法
    *  2、当一个请求的路径满足过滤器配置路径的时候,执行doFilter()方法
    *  3、当服务器停止的时候,销毁服务器.执行destory()方法
    *
    *
    * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo01过滤器初始化了...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo01放行...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("服务器停止的时候调用destroy方法...");
    }
}
