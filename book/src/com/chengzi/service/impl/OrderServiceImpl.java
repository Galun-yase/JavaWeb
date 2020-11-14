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

        Order order=new Order(orderId,userId,new Date());
        orderDao.saveOrder(order);

        for (Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            CartItem cartItem=entry.getValue();
            OrderItem orderItem=new OrderItem(null,userId);

            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);



        }

        cart.clear();
        return orderId;



    }
}
