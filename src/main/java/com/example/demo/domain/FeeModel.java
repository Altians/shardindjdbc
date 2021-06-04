package com.example.demo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class FeeModel implements Serializable {
    private String feeCode;
    private BigDecimal mustPayAmount;
    private BigDecimal actualPayAmount;
    private String feeName;

    public FeeModel() {
    }

    public FeeModel(String feeCode, BigDecimal mustPayAmount, BigDecimal actualPayAmount, String feeName) {
        this.feeCode = feeCode;
        this.mustPayAmount = mustPayAmount;
        this.actualPayAmount = actualPayAmount;
        this.feeName = feeName;
    }

    public String getFeeName() {
        return this.feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getFeeCode() {
        return this.feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public BigDecimal getMustPayAmount() {
        return this.mustPayAmount;
    }

    public void setMustPayAmount(BigDecimal mustPayAmount) {
        this.mustPayAmount = mustPayAmount;
    }

    public BigDecimal getActualPayAmount() {
        return this.actualPayAmount;
    }

    public void setActualPayAmount(BigDecimal actualPayAmount) {
        this.actualPayAmount = actualPayAmount;
    }

    @Override
    public String toString() {
        return "FeeModel{" +
                "feeCode='" + feeCode + '\'' +
                ", mustPayAmount=" + mustPayAmount +
                ", actualPayAmount=" + actualPayAmount +
                ", feeName='" + feeName + '\'' +
                '}';
    }
}
