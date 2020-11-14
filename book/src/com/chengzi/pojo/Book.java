package com.chengzi.pojo;

import java.math.BigDecimal;

public class Book {

    private Integer id;
    private String title;
    private String building_num;
    private String building_unit;
    private String building_floor_num;
    private BigDecimal rent;
    private String orientation;//朝向
    private String contact;//联系人
    private String mobile;//联系电话


    public Book() {
    }

    public Book(Integer id, String title, String building_num, String building_unit, String building_floor_num, BigDecimal rent, String orientation, String contact, String mobile) {
        this.id = id;
        this.title = title;
        this.building_num = building_num;
        this.building_unit = building_unit;
        this.building_floor_num = building_floor_num;
        this.rent = rent;
        this.orientation = orientation;
        this.contact = contact;
        this.mobile = mobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBuilding_num() {
        return building_num;
    }

    public void setBuilding_num(String building_num) {
        this.building_num = building_num;
    }

    public String getBuilding_unit() {
        return building_unit;
    }

    public void setBuilding_unit(String building_unit) {
        this.building_unit = building_unit;
    }

    public String getBuilding_floor_num() {
        return building_floor_num;
    }

    public void setBuilding_floor_num(String building_floor_num) {
        this.building_floor_num = building_floor_num;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
