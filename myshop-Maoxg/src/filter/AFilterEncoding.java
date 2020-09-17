package filter;

import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AFilterEncoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 不处理
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
         转换数据类型，请求和响应都是处理为对应的HttpServletRequest和HttpServletResponse
         因为目前情况下从前端页面到后台Tomcat服务器基于的网络传输协议是Http协议
        */
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        /*
        获取Tomcat服务器版本号
            ServletContext是Servlet上下文对象，也是当前整个项目的全局对象
         */
        String serverInfo = req.getServletContext().getServerInfo();

        // 判断Tomcat8和Tomcat9服务器软件
        if (serverInfo.startsWith("Apache Tomcat/8") || serverInfo.startsWith("Apache Tomcat/9")) {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
        }

        // 放行符合要求的Request和Response对象
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        // 不处理
    }
}
