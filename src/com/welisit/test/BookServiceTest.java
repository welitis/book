package com.welisit.test;

import com.welisit.bean.Book;
import com.welisit.bean.Page;
import com.welisit.service.BookService;
import com.welisit.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author welisit
 * @ClassName BookServiceTest
 * @Description TODO
 * @Date 2020-03-20 8:38
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥在手，天下我有！", "1125", new BigDecimal(1000000),
                100000000, 0, null));
    }
    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }
    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"社会我国哥，人狠话不多！", "1125", new BigDecimal(999999),
                10, 111110, null));
    }
    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }
    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void pageByPrice() {
        Page<Book> bookPage = bookService.pageByPrice(2, 3, 6, 66);
        bookPage.getItems().forEach(System.out::println);
        System.out.println(bookPage.getPageNo());
        System.out.println(bookPage.getPageTotal());
        System.out.println(bookPage.getPageTotalCount());
    }
}