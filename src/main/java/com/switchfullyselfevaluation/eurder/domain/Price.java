package com.switchfullyselfevaluation.eurder.domain;

public class Price {

    private double value;
    private String currency;

    public Price(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public Price setValue(double value) {
        this.value = value;
        return this;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
