package com.welisit.dao;

import com.welisit.bean.OrderItem;

import java.util.List;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 12:52
 */
public interface OrderItemDAO {
    /**
     * 保存订单商品项进入数据库
     * @param orderItem
     * @return
     */
    int saveOrderItem(OrderItem orderItem);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    List<OrderItem> queryItemsById(String orderId);
}
