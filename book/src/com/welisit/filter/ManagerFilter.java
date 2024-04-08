package com.welisit.filter;

import com.welisit.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 23:04
 */
public class ManagerFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("进入过滤器");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("用户没有登录");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/pages/user/login.jsp?lastUrl=" + httpServletRequest.getHeader("Referer"));
            return;
        }
        chain.doFilter(req, resp);
        System.out.println("退出过滤器");
    }

}
