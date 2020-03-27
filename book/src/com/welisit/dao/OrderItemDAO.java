package com.welisit.dao;

import com.welisit.bean.OrderItem;

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
}
