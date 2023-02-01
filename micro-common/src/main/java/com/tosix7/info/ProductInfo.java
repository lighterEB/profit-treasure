package com.tosix7.info;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品信息表
 */
public class ProductInfo {
    private Integer id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品利率
     */
    private BigDecimal rate;

    /**
     * 产品期限
     */
    private Integer cycle;

    /**
     * 产品发布时间
     */
    private Date releaseTime;

    /**
     * 产品类型 0：新手宝 1：优选产品 2：散标产品
     */
    private Integer productType;

    /**
     * 产品编号
     */
    private String productNo;

    /**
     * 产品金额
     */
    private BigDecimal productMoney;

    /**
     * 产品剩余可投金额
     */
    private BigDecimal leftProductMoney;

    /**
     * 最低投资金额，即起投金额
     */
    private BigDecimal bidMinLimit;


    /**
     * 最高投资金额，即最高能投多少金额
     */
    private BigDecimal bidMaxLimit;
    /**
     * 产品状态（0：未满标 1：已满标 2：满标已生成收益计划）
     */
    private Integer productStatus;

    /**
     * 产品投资满标时间
     */
    private Date productFullTime;

    /**
     * 产品描述
     */
    private String productDesc;

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", rate=" + rate +
                ", cycle=" + cycle +
                ", releaseTime=" + releaseTime +
                ", productType=" + productType +
                ", productNo='" + productNo + '\'' +
                ", productMoney=" + productMoney +
                ", leftProductMoney=" + leftProductMoney +
                ", bidMinLimit=" + bidMinLimit +
                ", bidMaxLimit=" + bidMaxLimit +
                ", productStatus=" + productStatus +
                ", productFullTime=" + productFullTime +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public BigDecimal getProductMoney() {
        return productMoney;
    }

    public void setProductMoney(BigDecimal productMoney) {
        this.productMoney = productMoney;
    }

    public BigDecimal getLeftProductMoney() {
        return leftProductMoney;
    }

    public void setLeftProductMoney(BigDecimal leftProductMoney) {
        this.leftProductMoney = leftProductMoney;
    }

    public BigDecimal getBidMinLimit() {
        return bidMinLimit;
    }

    public void setBidMinLimit(BigDecimal bidMinLimit) {
        this.bidMinLimit = bidMinLimit;
    }

    public BigDecimal getBidMaxLimit() {
        return bidMaxLimit;
    }

    public void setBidMaxLimit(BigDecimal bidMaxLimit) {
        this.bidMaxLimit = bidMaxLimit;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Date getProductFullTime() {
        return productFullTime;
    }

    public void setProductFullTime(Date productFullTime) {
        this.productFullTime = productFullTime;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public ProductInfo() {
    }

    public ProductInfo(Integer id, String productName, BigDecimal rate, Integer cycle, Date releaseTime, Integer productType, String productNo, BigDecimal productMoney, BigDecimal leftProductMoney, BigDecimal bidMinLimit, BigDecimal bidMaxLimit, Integer productStatus, Date productFullTime, String productDesc) {
        this.id = id;
        this.productName = productName;
        this.rate = rate;
        this.cycle = cycle;
        this.releaseTime = releaseTime;
        this.productType = productType;
        this.productNo = productNo;
        this.productMoney = productMoney;
        this.leftProductMoney = leftProductMoney;
        this.bidMinLimit = bidMinLimit;
        this.bidMaxLimit = bidMaxLimit;
        this.productStatus = productStatus;
        this.productFullTime = productFullTime;
        this.productDesc = productDesc;
    }
}
