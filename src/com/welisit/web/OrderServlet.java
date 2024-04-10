package com.welisit.web;

import com.welisit.bean.Cart;
import com.welisit.bean.Order;
import com.welisit.bean.OrderItem;
import com.welisit.bean.User;
import com.welisit.service.OrderService;
import com.welisit.service.impl.OrderServiceImpl;
import com.welisit.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp?lastUrl=" + request.getHeader("Referer"));
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
        List<Order> orderList = orderService.showAllOrders();
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
}

    /**
     * 发货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.sendOrder(orderId);
        response.sendRedirect(request.getHeader("Referer"));
    }

    /**
     * 确认收货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.receiveOrder(orderId);
        response.sendRedirect(request.getContextPath() + "/orderServlet?action=showMyOrders");
    }

    /**
     * 查询我的订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/pages/user/login.jsp?lastUrl=" + request.getHeader("Referer"));
            return;
        }
        List<Order> orderList = orderService.showMyOrders(user.getId());
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
    }

    /**
     * 查询订单详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取订单号
        String orderId = request.getParameter("orderId");
        List<OrderItem> itemList = orderService.showOrderDetail(orderId);
        Order order = orderService.getOrderById(orderId);
        request.setAttribute("itemList", itemList);
        request.setAttribute("order", order);
        request.getRequestDispatcher("/pages/order/order_detail.jsp").forward(request, response);
    }
}
