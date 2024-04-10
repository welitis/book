package com.welisit.filter;

import com.welisit.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author welisit
 * @create 2020-03-28 15:18
 */
public class TranslationFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            e.printStackTrace();
            JdbcUtils.rollbackAndClose();
            throw new RuntimeException();
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
