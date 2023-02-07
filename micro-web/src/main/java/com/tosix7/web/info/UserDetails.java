package com.tosix7.web.info;

import java.io.Serializable;

/**
 * 前端传来的用户信息实体类
 */
public class UserDetails implements Serializable {

    /**
     * 用户手机号码
     */
    private String poneNum;

    /**
     * 用户密码
     */
    private String password;

    @Override
    public String toString() {
        return "UserDetails{" +
                "poneNum='" + poneNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPoneNum() {
        return poneNum;
    }

    public void setPoneNum(String poneNum) {
        this.poneNum = poneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails() {
    }

    public UserDetails(String poneNum, String password) {
        this.poneNum = poneNum;
        this.password = password;
    }
}
