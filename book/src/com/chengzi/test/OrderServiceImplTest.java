package com.chengzi.test;

import com.chengzi.pojo.Cart;
import com.chengzi.pojo.CartItem;
import com.chengzi.service.impl.OrderService;
import com.chengzi.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    @Test
    public void createOrder() {

        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(3,"从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));

        OrderService orderService=new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart,1));
    }
}