package com.tosix7.info;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户充值记录信息表
 */
public class RechargeRecordInfo {

    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 充值订单号
     */
    private String rechargeNo;

    /**
     * 充值订单状态(0:充值中 1:充值成功 2:充值失败)
     */
    private Integer rechargeStatus;

    /**
     * 充值金额
     */
    private BigDecimal rechargeMoney;

    /**
     * 充值时间
     */
    private Date rechargeTime;

    /**
     * 充值描述
     */
    private String rechargeDesc;

    /**
     * 充值渠道
     */
    private String channel;

    @Override
    public String toString() {
        return "RechargeRecordInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", rechargeNo='" + rechargeNo + '\'' +
                ", rechargeStatus=" + rechargeStatus +
                ", rechargeMoney=" + rechargeMoney +
                ", rechargeTime=" + rechargeTime +
                ", rechargeDesc='" + rechargeDesc + '\'' +
                ", channel='" + channel + '\'' +
                '}';
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

    public String getRechargeNo() {
        return rechargeNo;
    }

    public void setRechargeNo(String rechargeNo) {
        this.rechargeNo = rechargeNo;
    }

    public Integer getRechargeStatus() {
        return rechargeStatus;
    }

    public void setRechargeStatus(Integer rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getRechargeDesc() {
        return rechargeDesc;
    }

    public void setRechargeDesc(String rechargeDesc) {
        this.rechargeDesc = rechargeDesc;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public RechargeRecordInfo(Integer id, Integer uid, String rechargeNo, Integer rechargeStatus, BigDecimal rechargeMoney, Date rechargeTime, String rechargeDesc, String channel) {
        this.id = id;
        this.uid = uid;
        this.rechargeNo = rechargeNo;
        this.rechargeStatus = rechargeStatus;
        this.rechargeMoney = rechargeMoney;
        this.rechargeTime = rechargeTime;
        this.rechargeDesc = rechargeDesc;
        this.channel = channel;
    }

    public RechargeRecordInfo() {
    }
}
