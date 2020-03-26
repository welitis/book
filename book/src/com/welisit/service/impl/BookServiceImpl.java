package com.welisit.service.impl;

import com.welisit.bean.Book;
import com.welisit.bean.Page;
import com.welisit.dao.BookDAO;
import com.welisit.dao.impl.BookDAOImpl;
import com.welisit.service.BookService;

import java.util.List;

/**
 * @author welisit
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Date 2020-03-20 8:35
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        int pageTotalCount = bookDAO.queryPageTotalCountByPrice(min, max);
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 设置总页码数，如果余数大于0则要增加页数
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        // 参数设置 当前页码
        page.setPageNo(pageNo);

        // 设置页码记录集合 items
        int begin = ( page.getPageNo() - 1 ) * pageSize;
        List<Book> items = bookDAO.queryBooksByPageByPrice(begin, pageSize, min, max);
        page.setItems(items);

        page.setUrl("client/bookServlet");
        return page;
    }

    @Override
    public Page page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();

        int pageTotalCount = bookDAO.queryPageTotalCount();
        // 设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 设置总页码数，如果余数大于0则要增加页数
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        // 参数设置 当前页码
        page.setPageNo(pageNo);

        // 设置页码记录集合 items
        int begin = ( page.getPageNo() - 1 ) * pageSize;
        List<Book> items = bookDAO.queryBooksByPage(begin, pageSize);
        page.setItems(items);

        page.setUrl("manager/bookServlet");
        return page;
    }
}
