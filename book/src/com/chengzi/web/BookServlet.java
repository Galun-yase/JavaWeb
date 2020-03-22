package com.chengzi.web;

import com.chengzi.pojo.Book;
import com.chengzi.pojo.Page;
import com.chengzi.service.impl.BookService;
import com.chengzi.service.impl.BookServiceImpl;
import com.chengzi.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {

    BookService bookService=new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo和pageSize
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"),Page.PAGE_SIZE);
        //2、调用BookService.page(pageNo,pageSize)获得Page对象
        Page<Book> page=bookService.page(pageNo,pageSize);

        page.setUrl("manager/bookServlet?action=page");

        //3、保存Page对象到request域中
        req.setAttribute("page",page);
        //4、请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),0);
        pageNo+=1;


        //1、获取请求的对象，封装成Book对象
        Book book= WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2、调用BookService.addBook()保存图书
        bookService.addBook(book);
        //3、跳转到图书列表页面
        //req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        //此处采用重定向，解决bug，浏览器会记住最后一次提交请求，F5刷新时会再次执行这个请求，重复提交
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求删除id
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //2、调用bookService.deleteById,删除图书
        bookService.deleteBookById(id);
        //3、重定向到图书列表
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求修改的图书book对象
        Book book=WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2、调用bookService.updateBook,修改图书
        bookService.updateBook(book);
        //3、重定向回图书列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1通过BookService查询全部图书
        List<Book> books=bookService.queryBooks();
        //2把全部图书保存到Request域中
        req.setAttribute("books",books);
        //3请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);


    }


    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的图书编号
        int id=WebUtils.parseInt(req.getParameter("id"),0);
        //2、调用bookService.queryBookById查询图书
        Book book=bookService.queryBookById(id);
        //3、保存图书信息到request域中
        req.setAttribute("book",book);
        //4、请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }


}
