package com.example.demo.domain;

import java.io.Serializable;

public class FeeModelNewDto implements Serializable {
    private String feeCode;
    private String feeName;
    private String mustPayAmount;


    public FeeModelNewDto() {
    }

    public String getFeeCode() {
        return feeCode;
    }

    public void setFeeCode(String feeCode) {
        this.feeCode = feeCode;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getMustPayAmount() {
        return mustPayAmount;
    }

    public void setMustPayAmount(String mustPayAmount) {
        this.mustPayAmount = mustPayAmount;
    }

    @Override
    public String toString() {
        return "FeeModelNewDto{" +
                "feeCode='" + feeCode + '\'' +
                ", feeName='" + feeName + '\'' +
                ", mustPayAmount='" + mustPayAmount + '\'' +
                '}';
    }
}
