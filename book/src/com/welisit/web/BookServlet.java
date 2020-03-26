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
 * @ClassName ${NAME}
 * @Description TODO
 * @Date 2020-03-20 8:41
 */
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();


    /**
     * 分页操作，通过当前页pageNo、每页显示数量pageSize确定当前页数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 获取pageNo、pageSize参数
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        // 调用业务层方法处理分页业务
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        // 将数据保存进request域中
        req.setAttribute("page", page);
        // 计算展示的页码范围
        List<Integer> scopeList = WebUtils.getPageScopeList(page, 2);
        req.setAttribute("scopeList", scopeList);
        // 请求转发到显示页进行显示数据
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);


    }


    /**
     * 修改图书信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list&pageNo=" + pageNo);
    }

    /**
     * 获取修改某本图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String idStr = req.getParameter("id");
        int id = WebUtils.parseInt(idStr, 0);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Book book = bookService.queryBookById(id);
        req.setAttribute("book", book);
        req.setAttribute("action", "update");
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?id=" + id + "&pageNo=" + pageNo).forward(req, resp);
    }

    /**
     * 删除图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String idStr = req.getParameter("id");
        int id = WebUtils.parseInt(idStr, 0);
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        bookService.deleteBookById(id);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    /**
     * 增加图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        Book book = WebUtils.copyParamsToBean(req.getParameterMap(), new Book());
        int pageTotal = WebUtils.parseInt(req.getParameter("pageNo"), 1) + 1;
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageTotal);
    }

    /**
     * 查询所有图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Deprecated
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        //1 通过BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到Request 域中
        req.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp 页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}
