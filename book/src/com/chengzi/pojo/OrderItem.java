package com.chengzi.pojo;

import java.math.BigDecimal;

public class OrderItem {

    private Integer id;
    private Integer uid;


    public OrderItem() {
    }

    public OrderItem(Integer id,Integer uid) {
        this.id = id;
        this.uid=uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
