package com.chengzi.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private String orderId;
    private int uid;
    private Date createTime;

    public Order() {
    }

    public Order(String orderId,int uid, Date createTime) {
        this.orderId = orderId;
        this.uid=uid;
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
