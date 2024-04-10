package com.welisit.test;

import com.welisit.bean.Book;
import com.welisit.dao.BookDAO;
import com.welisit.dao.impl.BookDAOImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author welisit
 * @ClassName BookDAOTest
 * @Description TODO
 * @Date 2020-03-20 8:27
 */
public class BookDAOTest {
    private BookDAO bookDao = new BookDAOImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"国哥为什么这么帅！", "191125", new
                BigDecimal(9999),1100000,0,null
        ));
    }
    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }
    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"大家都可以这么帅！", "国哥", new
                BigDecimal(9999),1100000,0,null
        ));
    }
    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(21) );
    }
    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryPageTotalCount() {
        System.out.println(bookDao.queryPageTotalCount());
    }

    @Test
    public void queryBooksByPage() {
        List<Book> books = bookDao.queryBooksByPage(4, 5);
        books.forEach(System.out::println);
    }

    @Test
    public void queryPageTotalCountByPrice(){
        int i = bookDao.queryPageTotalCountByPrice(10, 20);
        System.out.println(i);
    }

    @Test
    public void queryBooksByPageByPrice(){
        List<Book> books = bookDao.queryBooksByPageByPrice(10, 5, 1, 90);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}