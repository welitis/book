package com.welisit.service;

import com.welisit.bean.Cart;

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
}
