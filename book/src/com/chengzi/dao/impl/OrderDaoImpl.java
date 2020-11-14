package com.chengzi.dao.impl;

import com.chengzi.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
       String sql="insert into tb_record(id,uid,time) values(?,?,?)";
       return update(sql,order.getOrderId(),order.getUid(),order.getCreateTime());
    }
}
