package com.welisit.web;

import com.welisit.bean.Cart;
import com.welisit.bean.Order;
import com.welisit.bean.User;
import com.welisit.service.OrderService;
import com.welisit.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author welisit
 * @Description 处理订单请求
 * @create 2020-03-27 8:24
 */
public class OrderServlet extends BaseServlet {


    private OrderService orderService = new OrderServiceImpl();
    /**
     * 创建订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp");
            return;
        }
        if (cart != null) {
            // 调用业务层方法生成订单
            String orderId = orderService.createOrder(cart, user.getId());
            request.getSession().setAttribute("orderId", orderId);
            response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
        }
    }

    /**
     * 管理员查看所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 发货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 确认收货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 查询我的订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * 查询订单详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
