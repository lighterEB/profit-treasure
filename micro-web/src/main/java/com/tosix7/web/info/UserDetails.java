package com.tosix7.web.info;

import java.math.BigDecimal;

public class UserDetails {

    private String phone;
    private String name;
    private String idCard;
    private String token;
    private String uid;
    private String money;

    public UserDetails() {
    }

    public UserDetails(String phone, String name, String idCard, String token, String uid, String money) {
        this.phone = phone;
        this.name = name;
        this.idCard = idCard;
        this.token = token;
        this.uid = uid;
        this.money = money;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", token='" + token + '\'' +
                ", uid='" + uid + '\'' +
                ", money=" + money +
                '}';
    }
}
