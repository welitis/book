package com.welisit.service.impl;

import com.welisit.bean.Cart;
import com.welisit.bean.CartItem;
import com.welisit.bean.Order;
import com.welisit.bean.OrderItem;
import com.welisit.dao.OrderDAO;
import com.welisit.dao.OrderItemDAO;
import com.welisit.dao.impl.OrderDAOImpl;
import com.welisit.dao.impl.OrderItemDAOImpl;
import com.welisit.service.OrderService;
import com.welisit.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Random;

/**
 * @author welisit
 * @Description 订单业务实现类
 * @create 2020-03-27 8:35
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDao = new OrderDAOImpl();
    private OrderItemDAO orderItemDao = new OrderItemDAOImpl();

    @Override
    public String createOrder(Cart cart, Integer id) {
        // 将购物车的商品信息保存进订单
        // 订单号 唯一性
        String orderId = System.currentTimeMillis() + "" + new Random().nextInt(9) + id;
        Order order = new Order(orderId, new Date(System.currentTimeMillis()), cart.getTotalPrice(), id);
        // 保存订单
        orderDao.saveOrder(order);

        // 保存商品项
        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(item.getId(), item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            System.out.println(item.getId());
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存销量
        }

        // 清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return orderDao.queryAllOrder();
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return orderItemDao.queryItemsById(orderId);
    }

    @Override
    public List<Order> showMyOrders(Integer id) {

        return orderDao.queryOrdersByUserId(id);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.updateStatusById(2, orderId);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderDao.queryOneById(orderId);
    }

    @Override
    public void sendOrder(String orderId) {
        /**
         * 状态码1：发货
         */
        Integer status = 1;
        orderDao.updateStatusById(status, orderId);
    }
}
