package com.chengzi.dao.impl;

import com.chengzi.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into tb_contract(aid,bid,hourseid,agent_id) values(?,?,?,?)";
        return update(sql,1,2,1,1);
    }
}
