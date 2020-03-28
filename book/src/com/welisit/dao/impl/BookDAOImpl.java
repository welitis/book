package com.welisit.dao.impl;

import com.welisit.bean.Book;
import com.welisit.dao.BookDAO;
import com.welisit.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author welisit
 * @ClassName BookDAOImpl
 * @Description TODO
 * @Date 2020-03-20 8:18
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public int addBook(Book book) {
        Connection connection = null;
        int count = 0;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
            count = update(connection, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int deleteBookById(Integer id) {
        Connection connection = null;
        int count = 0;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "delete from t_book where id = ?";
            count = update(connection, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int queryPageTotalCount() {
        Connection connection = null;
        int pageTotalCount = 0;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select count(id) from t_book";
            Long value = (Long) queryForSingleValue(connection, sql);
            pageTotalCount = value.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageTotalCount;
    }

    @Override
    public int queryPageTotalCountByPrice(int min, int max) {
        Connection connection = null;
        int pageTotalCount = 0;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select count(*) from t_book where price between ? and ?";
            Number value = (Number) queryForSingleValue(connection, sql, min, max);
            pageTotalCount = value.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pageTotalCount;
    }

    @Override
    public List<Book> queryBooksByPageByPrice(int begin, int pageSize, int min, int max) {
        Connection connection = null;
        List<Book> books = null;
        try {
            String sql = "select * from `t_book` where `price` between ? and ? order by `price` limit ?,?";
            connection = JdbcUtils.getConnection();
            books = queryForAll(connection, sql, min, max, begin, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> queryBooksByPage(int begin, Integer pageSize) {
        Connection connection = null;
        List<Book> books = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from t_book limit ?,?";
            books = queryForAll(connection, sql, begin, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int updateBook(Book book) {
        Connection connection = null;
        int count = 0;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
            count = update(connection, sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Book queryBookById(Integer id) {
        Connection connection = null;
        Book book = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath " +
                    "from t_book where id = ?";
            book = queryForOne(connection, sql, id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> queryBooks() {
        Connection connection = null;
        List<Book> bookList = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
            bookList = queryForAll(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
