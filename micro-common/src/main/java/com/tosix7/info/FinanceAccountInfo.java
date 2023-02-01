package com.tosix7.info;

import java.math.BigDecimal;

/**
 * 用户可用资金表
 */
public class FinanceAccountInfo {

    private Integer id;

    /**
     * 用户ID
     */
    private Integer uid;

    /**
     * 用户可用资金
     */
    private BigDecimal availableMoney;

    @Override
    public String toString() {
        return "FinanceAccountInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", availableMoney=" + availableMoney +
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

    public BigDecimal getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigDecimal availableMoney) {
        this.availableMoney = availableMoney;
    }

    public FinanceAccountInfo() {
    }

    public FinanceAccountInfo(Integer id, Integer uid, BigDecimal availableMoney) {
        this.id = id;
        this.uid = uid;
        this.availableMoney = availableMoney;
    }
}
