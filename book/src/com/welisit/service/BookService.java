package com.welisit.service;

import com.welisit.bean.Book;
import com.welisit.bean.Page;

import java.util.List;

/**
 * @author welisit
 * @ClassName BookService
 * @Description TODO
 * @Date 2020-03-20 8:33
 */
public interface BookService {
    /**
     * 添加图书
     *
     * @param book
     */
    void addBook(Book book);

    /**
     * 删除图书
     *
     * @param id
     */
    void deleteBookById(Integer id);

    /**
     * 修改图书
     *
     * @param book
     */
    void updateBook(Book book);


    /**
     * 查询单个图书
     *
     * @param id
     * @return
     */
    Book queryBookById(Integer id);


    /**
     * 查询多个图书
     *
     * @return
     */
    List<Book> queryBooks();

    /**
     * 通过当前的页数和总页数查询当前页的内容
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page page(Integer pageNo, Integer pageSize);

    /**
     * 通过价格范围查询数据
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
