package com.welisit.test;

import com.welisit.bean.OrderItem;
import com.welisit.dao.OrderItemDAO;
import com.welisit.dao.impl.OrderItemDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 13:03
 */
public class OrderItemDAOTest {

    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();

    @Test
    public void saveOrderItem() {
        String orderId = "0121212";
        OrderItem orderItem = new OrderItem(21, "asda", 2, new BigDecimal("23"), new BigDecimal(64), orderId);
        orderItemDAO.saveOrderItem(orderItem);
    }

    @Test
    public void queryItemsById(){
        List<OrderItem> itemList = orderItemDAO.queryItemsById("158529931762381");
        for (OrderItem orderItem : itemList) {
            System.out.println(orderItem);
        }
    }
}