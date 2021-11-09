package com.switchfullyselfevaluation.eurder.domain.user;

public class Address {
    private final String streetAndNumber;
    private final String postalCode;
    private final String city;

    public Address(String streetAndNumber, String postalCode, String city) {
        this.streetAndNumber = streetAndNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
