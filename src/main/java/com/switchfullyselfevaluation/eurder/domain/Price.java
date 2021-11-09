package com.switchfullyselfevaluation.eurder.domain;

public class Price {

    private double value;
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




    //STORY 3: total price for ordering as customer

    public void setValue(double value) {
        this.value = value;
    }
}
