package com.chengzi.test;

import com.chengzi.pojo.Cart;
import com.chengzi.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

    }

    @Test
    public void clear() {
    }

    @Test
    public void updateCount() {
    }
}