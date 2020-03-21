package com.chengzi.test;


import com.chengzi.pojo.Book;
import com.chengzi.service.impl.BookService;
import com.chengzi.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥在手，天下我有！", "1125", new BigDecimal(1000000), 100000000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(25);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(20,"社会我国哥，人狠话不多！", "1125", new BigDecimal(999999), 10, 111110, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(26));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}