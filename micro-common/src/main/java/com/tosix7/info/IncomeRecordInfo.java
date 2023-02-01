package com.tosix7.info;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户投标收益记录
 */
public class IncomeRecordInfo {

    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 产品ID
     */
    private Integer prodId;

    /**
     * 投标记录ID
     */
    private Integer bidId;

    /**
     * 投资金额
     */
    private BigDecimal bidMoney;

    /**
     * 到期时间
     */
    private Date incomeDate;

    /**
     * 收益金额
     */
    private BigDecimal incomeMoney;

    /**
     * 收益状态（0：未返 1：已返）
     */
    private Integer incomeStatus;

    @Override
    public String toString() {
        return "IncomeRecordInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", prodId=" + prodId +
                ", bidId=" + bidId +
                ", bidMoney=" + bidMoney +
                ", incomeDate=" + incomeDate +
                ", incomeMoney=" + incomeMoney +
                ", incomeStatus=" + incomeStatus +
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

    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(Integer prodId) {
        this.prodId = prodId;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public BigDecimal getBidMoney() {
        return bidMoney;
    }

    public void setBidMoney(BigDecimal bidMoney) {
        this.bidMoney = bidMoney;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public Integer getIncomeStatus() {
        return incomeStatus;
    }

    public void setIncomeStatus(Integer incomeStatus) {
        this.incomeStatus = incomeStatus;
    }

    public IncomeRecordInfo() {
    }

    public IncomeRecordInfo(Integer id, Integer uid, Integer prodId, Integer bidId, BigDecimal bidMoney, Date incomeDate, BigDecimal incomeMoney, Integer incomeStatus) {
        this.id = id;
        this.uid = uid;
        this.prodId = prodId;
        this.bidId = bidId;
        this.bidMoney = bidMoney;
        this.incomeDate = incomeDate;
        this.incomeMoney = incomeMoney;
        this.incomeStatus = incomeStatus;
    }
}
