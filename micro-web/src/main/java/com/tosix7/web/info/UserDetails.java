package com.tosix7.web.info;

import java.io.Serializable;

/**
 * 前端传来的用户信息实体类
 */
public class UserDetails implements Serializable {

    /**
     * 用户手机号码
     */
    private String phoneNum;

    /**
     * 用户密码
     */
    private String password;

    @Override
    public String toString() {
        return "UserDetails{" +
                "phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails() {
    }

    public UserDetails(String phoneNum, String password) {
        this.phoneNum = phoneNum;
        this.password = password;
    }
}
