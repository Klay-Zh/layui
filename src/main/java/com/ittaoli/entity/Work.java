package com.ittaoli.entity;

import java.util.Date;

public class Work {
    private Integer id;

    private String orderId;

    private String carId;

    private Integer serverType;

    private Integer waiterId;

    private Integer repairId;

    private Integer addPr;

    private Integer adjustPr;

    private Integer realPr;

    private Integer payType;

    private Integer payState;

    private Integer carKm;

    private Date createTime;

    private Date payTime;

    private Date checkoutTime;

    private String serverSug;

    private String salePolicy;

    private String maintainSug;

    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public Integer getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(Integer waiterId) {
        this.waiterId = waiterId;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getAddPr() {
        return addPr;
    }

    public void setAddPr(Integer addPr) {
        this.addPr = addPr;
    }

    public Integer getAdjustPr() {
        return adjustPr;
    }

    public void setAdjustPr(Integer adjustPr) {
        this.adjustPr = adjustPr;
    }

    public Integer getRealPr() {
        return realPr;
    }

    public void setRealPr(Integer realPr) {
        this.realPr = realPr;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getCarKm() {
        return carKm;
    }

    public void setCarKm(Integer carKm) {
        this.carKm = carKm;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getServerSug() {
        return serverSug;
    }

    public void setServerSug(String serverSug) {
        this.serverSug = serverSug == null ? null : serverSug.trim();
    }

    public String getSalePolicy() {
        return salePolicy;
    }

    public void setSalePolicy(String salePolicy) {
        this.salePolicy = salePolicy == null ? null : salePolicy.trim();
    }

    public String getMaintainSug() {
        return maintainSug;
    }

    public void setMaintainSug(String maintainSug) {
        this.maintainSug = maintainSug == null ? null : maintainSug.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}