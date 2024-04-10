package com.welisit.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDAO<T> {

    private QueryRunner runner = new QueryRunner();
    private Class<T> clazz;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) actualTypeArguments[0];
    }

    /**
     * 对数据库进行更新操作 insert/update/delete
     * @param conn
     * @param sql
     * @param args
     * @return
     */
    public int update(Connection conn, String sql, Object ...args) throws SQLException {
        return runner.update(conn, sql, args);
    }

    /**
     * 查询一条记录，返回一个Javabean对象
     * @param conn
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public T queryForOne(Connection conn, String sql, Object ...args) throws SQLException {
        BeanHandler<T> handler = new BeanHandler<>(clazz);
        return runner.query(conn, sql, handler, args);
    }

    /**
     * 查询多条记录，返回一个List集合
     * @param conn
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public List<T> queryForAll(Connection conn, String sql, Object ...args) throws SQLException {
        BeanListHandler<T> handler = new BeanListHandler<>(clazz);
        return runner.query(conn, sql, handler, args);
    }

    /**
     * 查询单个值，例如 最大值最小值等
     * @param conn
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public Object queryForSingleValue(Connection conn, String sql, Object ...args) throws SQLException {
        ScalarHandler handler = new ScalarHandler();
        return runner.query(conn, sql, handler, args);
    }
}
