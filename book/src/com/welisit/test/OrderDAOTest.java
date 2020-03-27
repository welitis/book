package com.welisit.test;

import com.welisit.bean.Order;
import com.welisit.dao.OrderDAO;
import com.welisit.dao.impl.OrderDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;

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
}