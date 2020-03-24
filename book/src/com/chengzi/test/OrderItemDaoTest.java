package com.chengzi.test;

import com.chengzi.dao.impl.OrderItemDao;

import com.chengzi.dao.impl.OrderItemDaoImpl;
import com.chengzi.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {

        OrderItemDao orderItemDao=new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java",1,new BigDecimal(111),new BigDecimal(11),"1234453"));

    }
}