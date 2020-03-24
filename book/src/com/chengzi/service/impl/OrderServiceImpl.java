package com.chengzi.service.impl;

import com.chengzi.dao.impl.BookDao;
import com.chengzi.dao.impl.BookDaoImpl;
import com.chengzi.dao.impl.OrderDao;
import com.chengzi.dao.impl.OrderDaoImpl;
import com.chengzi.dao.impl.OrderItemDao;
import com.chengzi.dao.impl.OrderItemDaoImpl;
import com.chengzi.pojo.Book;
import com.chengzi.pojo.Cart;
import com.chengzi.pojo.CartItem;
import com.chengzi.pojo.Order;
import com.chengzi.pojo.OrderItem;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {

        //创建唯一订单号
        String orderId=System.currentTimeMillis()+""+userId;

        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            CartItem cartItem=entry.getValue();
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);

            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);


            //生成订单后对应销量和库存也要更新
            Book book=bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();
        return orderId;



    }
}
