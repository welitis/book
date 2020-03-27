package com.welisit.dao.impl;

import com.welisit.bean.User;
import com.welisit.dao.UserDAO;
import com.welisit.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {
    @Override
    public User queryUserByUsername(String username) {
        User user = null;
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select `id`, `username` `name`, `password`, `email` from `t_user` where `username` = ?";
            user = queryForOne(conn, sql, username);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return user;
    }

    @Override
    public int saveUser(User user) {
        int count = 0;
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "insert into `t_user`(username, password, email) values(?,?,?)";
            count = update(connection, sql, user.getUsername(), user.getPassword(), user.getEmail());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return count;
    }

    @Override
    public User queryUserByUnameAndPasswd(String username, String password) {
        Connection connection = null;
        User user = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select `id`, `username`, `password`, `email` from `t_user` where username = ? and password = ?";
            user = queryForOne(connection, sql, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }

        return user;
    }
}
