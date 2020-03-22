package com.chengzi.test;


import com.chengzi.dao.impl.BookDao;
import com.chengzi.dao.impl.BookDaoImpl;
import com.chengzi.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"国哥为什么这么帅！", "191125", new BigDecimal(9999),1100000,0,null
                ));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(24);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(23,"大家都可以这么帅！", "国哥", new BigDecimal(99),1100000,0,null
        ));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(20) );
    }




    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,500000));
        System.out.println(bookDao.queryForPageItemsByPrice(0,4,1,66666));
    }



}