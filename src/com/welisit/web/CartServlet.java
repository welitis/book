package com.welisit.web;

import com.welisit.bean.Book;
import com.welisit.bean.Cart;
import com.welisit.bean.CartItem;
import com.welisit.service.BookService;
import com.welisit.service.impl.BookServiceImpl;
import com.welisit.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author welisit
 * @Description 购物车模块请求处理
 * @create 2020-03-26 21:42
 */
public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    /**
     * 添加购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数中的商品id及上级跳转页
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        String referer = req.getHeader("Referer");
        // 创建商品项数据
        Book book = bookService.queryBookById(id);
        if (book == null) {
            System.out.println("查询的bookId不存在");
            resp.setStatus(403);
            return;
        }
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice());
        // 调用购物车模型方法添加商品进购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 保存购物车对象进session中
        if (cart == null) {
            // 如果是第一次加入购物车，则创建购物车对象
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(item);
        System.out.println("添加商品【" + item.getName() + "】进入购物车");
        req.getSession().setAttribute("lastName", item.getName());
        // 返回首页
        resp.sendRedirect(referer);
    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String referer = req.getHeader("Referer");
        if (cart != null) {
            cart.clear();
        }
        resp.sendRedirect(referer);
    }

    /**
     * 删除购物车中某个商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取删除商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItemById(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 更新商品数量
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateItemCount(id, count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void test(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进来了");
        resp.setStatus(200);
    }
}
