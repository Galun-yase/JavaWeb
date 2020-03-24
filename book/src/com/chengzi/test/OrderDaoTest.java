package com.chengzi.test;


import com.chengzi.dao.impl.OrderDao;
import com.chengzi.dao.impl.OrderDaoImpl;
import com.chengzi.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoTest {

    @Test
    public void saveOrder() {

        OrderDao orderDao=new OrderDaoImpl();

        orderDao.saveOrder(new Order("1234453",new Date(),new BigDecimal(10),0,1));
    }
}