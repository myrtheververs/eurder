package com.switchfullyselfevaluation.eurder.domain;

public class Price {

    private final double value;
    private final String currency;

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
}
