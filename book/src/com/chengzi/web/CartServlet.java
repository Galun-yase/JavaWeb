package com.chengzi.web;

import com.chengzi.pojo.Book;
import com.chengzi.pojo.Cart;
import com.chengzi.pojo.CartItem;
import com.chengzi.service.impl.BookService;
import com.chengzi.service.impl.BookServiceImpl;
import com.chengzi.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);

        //查询图书信息
        Book book = bookService.queryBookById(id);

        //把图书信息转为cartItem
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //添加商品
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }


        cart.addItem(cartItem);

        //最后一个添加的商品名称
        req.getSession().setAttribute("lastname",cartItem.getName());

        //重定向返回原商品界面
        resp.sendRedirect(req.getHeader("Referer"));


    }


    protected void ajaxaddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);

        //查询图书信息
        Book book = bookService.queryBookById(id);

        //把图书信息转为cartItem
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //添加商品
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }


        cart.addItem(cartItem);

        //最后一个添加的商品名称
        req.getSession().setAttribute("lastname",cartItem.getName());

//        //重定向返回原商品界面
//        resp.sendRedirect(req.getHeader("Referer"));

        //6、返回购物车总的商品数量和最后一个添加的商品名称
        Map<String,Object> resultMap=new HashMap<>();

        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());

        Gson gson=new Gson();
        String resultMapJsonString=gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);


    }


    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteItem(id);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }


    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clear();
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = WebUtils.parseInt(req.getParameter("bookId"), 0);
        int count=WebUtils.parseInt(req.getParameter("count"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(id,count);
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }
}