package com.welisit.test;

import com.welisit.bean.Order;
import com.welisit.dao.OrderDAO;
import com.welisit.dao.impl.OrderDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 12:58
 */
public class OrderDAOTest {
    private OrderDAO orderDAO = new OrderDAOImpl();

    @Test
    public void saveOrder() {
        Order order = new Order("0121212", new Date(System.currentTimeMillis()), new BigDecimal(320), 2);
        orderDAO.saveOrder(order);
    }

    @Test
    public void queryAllOrder(){
        List<Order> orders = orderDAO.queryAllOrder();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void updateStatusById(){
        orderDAO.updateStatusById(0, "158529931762381");
    }

    @Test
    public void queryOneById(){
        Order order = orderDAO.queryOneById("158531484458601");
        System.out.println(order);
    }

    @Test
    public void queryOrdersByUserId(){
        List<Order> orders = orderDAO.queryOrdersByUserId(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}