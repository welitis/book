package com.welisit.service;

import com.welisit.bean.Cart;
import com.welisit.bean.Order;
import com.welisit.bean.OrderItem;

import java.util.List;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 8:34
 */
public interface OrderService {
    /**
     * 创建订单
     * @param cart
     * @param id
     * @return
     */
    String createOrder(Cart cart, Integer id);

    /**
     * 查看所有订单
     * @return
     */
    List<Order> showAllOrders();

    /**
     * 发货
     * @param orderId
     */
    void sendOrder(String orderId);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    List<OrderItem> showOrderDetail(String orderId);
}
