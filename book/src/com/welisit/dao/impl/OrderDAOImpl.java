package com.welisit.dao.impl;

import com.welisit.bean.Order;
import com.welisit.dao.OrderDAO;
import com.welisit.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author welisit
 * @Description TODO
 * @create 2020-03-27 8:34
 */
public class OrderDAOImpl extends BaseDAO<Order> implements OrderDAO {
    @Override
    public List<Order> queryOrdersByUserId(Integer id) {
        Connection connection = null;
        List<Order> orderList = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select `order_id` `orderId`, `create_time` `createTime`, `total_money` `price`, `status`, " +
                    "`user_id` `userId` from t_order where `user_id` = ?";
            orderList = queryForAll(connection, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return orderList;
    }

    @Override
    public Order queryOneById(String orderId) {
        Connection connection = null;
        Order order = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select `order_id` `orderId`, `create_time` `createTime`, `total_money` `price`, `status`, " +
                    "`user_id` `userId` from `t_order` where `order_id` = ?";
            order = queryForOne(connection, sql, orderId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return order;
    }

    @Override
    public int saveOrder(Order order) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "insert into t_order(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values(?,?,?,?,?)";
            return update(connection, sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void updateStatusById(Integer status, String id) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "update `t_order` set `status` = ? where `order_id` = ?";
            update(connection, sql, status, id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<Order> queryAllOrder() {
        Connection connection = null;
        List<Order> orderList = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select `order_id` `orderId`, `create_time` `createTime`, `total_money` `price`, `status`, `user_id` `userId` from t_order";
            orderList = queryForAll(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return orderList;
    }
}
