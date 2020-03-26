package com.welisit.web;

import com.welisit.bean.Book;
import com.welisit.bean.Page;
import com.welisit.service.BookService;
import com.welisit.service.impl.BookServiceImpl;
import com.welisit.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-22 20:43
 */
public class ClientBookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 获取pageNo、pageSize参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 调用业务层方法处理分页业务
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("client/bookServlet?action=page");
        // 将数据保存进request域中
        req.setAttribute("page", page);
        // 计算展示的页码范围
        List<Integer> scopeList = WebUtils.getPageScopeList(page, 2);
        req.setAttribute("scopeList", scopeList);
        // 请求转发到显示页进行显示数据
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }

    /**
     * 通过价格查询记录数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 获取最大最小值范围
        int min = WebUtils.parseInt(req.getParameter("min"), 0);
        int max = WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);
        // 获取pageNo、pageSize参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);

        // 调用业务层方法查询
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        // 计算展示的页码范围
        List<Integer> scopeList = WebUtils.getPageScopeList(page, 2);
        req.setAttribute("scopeList", scopeList);
        // 保存进request
        req.setAttribute("page", page);
        // 请求转发到首页
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
