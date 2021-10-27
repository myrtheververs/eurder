package com.switchfullyselfevaluation.eurder.domain;

public class User {
    private final String uuid;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;

    public User(String uuid, String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
