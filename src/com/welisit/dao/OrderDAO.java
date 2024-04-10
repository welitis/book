package com.welisit.dao;

import com.welisit.bean.Cart;
import com.welisit.bean.Order;
import com.welisit.bean.OrderItem;

import java.util.List;

/**
 * @author welisit
 * @Description 订单表数据DAO
 * @create 2020-03-27 0:40
 */
public interface OrderDAO {
    /**
     * 保存订单对象进数据库
     * @param order
     * @return
     */
    int saveOrder(Order order);

    /**
     * 查询所有订单
     * @return
     */
    List<Order> queryAllOrder();

    /**
     * 更新状态
     * @param status
     * @param id
     */
    void updateStatusById(Integer status, String id);

    /**
     * 查询订单通过订单号
     * @param orderId
     * @return
     */
    Order queryOneById(String orderId);

    List<Order> queryOrdersByUserId(Integer id);
}
