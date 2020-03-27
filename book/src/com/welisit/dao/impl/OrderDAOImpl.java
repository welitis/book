package com.welisit.dao.impl;

import com.welisit.bean.Order;
import com.welisit.dao.OrderDAO;
import com.welisit.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 8:34
 */
public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";
            return update(connection, sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtils.close(connection);
        return 0;

    }
}
