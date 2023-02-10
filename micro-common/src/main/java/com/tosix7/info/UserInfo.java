package com.tosix7.info;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息
 */

public class UserInfo implements Serializable {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 登录密码
     */
    private String loginPassword;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户身份证号码
     */
    private String idCard;

    /**
     * 注册时间
     */
    private Date addTime;

    /**
     * 最近登录时间
     */
    private Date lastLoginTime;

    /**
     * 用户头像文件路径
     */
    private String headerImage;

    /**
     * 用户钱包金额
     */
    private BigDecimal money;

    public BigDecimal getMoney() {
        return money;
    }

    public UserInfo(Integer id, String phone, String loginPassword, String name, String idCard, Date addTime, Date lastLoginTime, String headerImage, BigDecimal money) {
        this.id = id;
        this.phone = phone;
        this.loginPassword = loginPassword;
        this.name = name;
        this.idCard = idCard;
        this.addTime = addTime;
        this.lastLoginTime = lastLoginTime;
        this.headerImage = headerImage;
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", addTime=" + addTime +
                ", lastLoginTime=" + lastLoginTime +
                ", headerImage='" + headerImage + '\'' +
                ", money=" + money +
                '}';
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public UserInfo() {
    }

}
