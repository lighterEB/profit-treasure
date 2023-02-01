package com.tosix7.info;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 投标信息表
 */
public class BidInfo {
    /**
     * 投标记录ID
     */
    private Integer id;

    /**
     * 产品ID
     */
    private Integer prodId;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 投标金额
     */
    private BigDecimal bidMoney;

    /**
     * 投标时间
     */
    private Date bidTime;

    /**
     * 投标状态
     */
    private Integer bidStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public BigDecimal getBidMoney() {
        return bidMoney;
    }

    public void setBidMoney(BigDecimal bidMoney) {
        this.bidMoney = bidMoney;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    public Integer getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(Integer bidStatus) {
        this.bidStatus = bidStatus;
    }

    public BidInfo(Integer id, Integer prodId, Integer uid, BigDecimal bidMoney, Date bidTime, Integer bidStatus) {
        this.id = id;
        this.prodId = prodId;
        this.uid = uid;
        this.bidMoney = bidMoney;
        this.bidTime = bidTime;
        this.bidStatus = bidStatus;
    }

    public BidInfo() {
    }

    @Override
    public String toString() {
        return "bidInfo{" +
                "id=" + id +
                ", prodId=" + prodId +
                ", uid=" + uid +
                ", bidMoney=" + bidMoney +
                ", bidTime=" + bidTime +
                ", bidStatus=" + bidStatus +
                '}';
    }
}
