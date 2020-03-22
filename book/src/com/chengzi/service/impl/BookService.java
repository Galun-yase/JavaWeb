package com.chengzi.service.impl;

import com.chengzi.pojo.Book;
import com.chengzi.pojo.Page;

import java.util.List;

public interface BookService {

    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Page<Book> page(int pageNo,int pageSize);


    public Page<Book> pageByPrice(int pageNo, int pageSize,int min,int max);
}
