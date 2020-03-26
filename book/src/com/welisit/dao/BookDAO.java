package com.welisit.dao;

import com.welisit.bean.Book;

import java.util.List;

/**
 * @author welisit
 * @ClassName BookDAO
 * @Description TODO
 * @Date 2020-03-20 8:15
 */
public interface BookDAO {
    /**
     * 增加图书
     *
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 删除图书
     *
     * @param id
     * @return
     */
    int deleteBookById(Integer id);

    /**
     * 修改图书
     *
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 查询一本书
     *
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询多本书
     *
     * @return
     */
    List<Book> queryBooks();

    /**
     * 查询总记录苏
     * @return
     */
    int queryPageTotalCount();

    /**
     * 通过页码查询book记录
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryBooksByPage(int begin, Integer pageSize);

    /**
     * 查询一定价格范围中的记录数
     * @param min
     * @param max
     * @return
     */
    int queryPageTotalCountByPrice(int min, int max);

    /**
     * 查询一定价格范围中记录的数据集合
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    List<Book> queryBooksByPageByPrice(int begin, int pageSize, int min, int max);
}
