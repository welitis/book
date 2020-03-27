package com.welisit.dao.impl;

import com.welisit.bean.Order;
import com.welisit.bean.OrderItem;
import com.welisit.dao.OrderItemDAO;
import com.welisit.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 12:53
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public List<OrderItem> queryItemsById(String orderId) {
        Connection connection = null;
        List<OrderItem> itemList = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select `id`, `name`, `price`, `total_money` `totalPrice`, `count`, `order_id` `orderId` from " +
                    "t_order_item where order_id = ?";
            itemList = queryForAll(connection, sql, orderId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JdbcUtils.close(connection);
        return itemList;
    }

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "insert into t_order_item(`name`,`count`,`price`,`total_money`,`order_id`) values(?,?,?,?,?)";
            return update(connection, sql, orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(), orderItem.getOrderId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JdbcUtils.close(connection);
        return 0;
    }
}
