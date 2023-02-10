package com.tosix7.web.info;

public class UserParam {
    private String phone;

    private String password;
    private String sms;

    @Override
    public String toString() {
        return "UserParam{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", sms='" + sms + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public UserParam(String phone, String password, String sms) {
        this.phone = phone;
        this.password = password;
        this.sms = sms;
    }

    public UserParam() {
    }
}
