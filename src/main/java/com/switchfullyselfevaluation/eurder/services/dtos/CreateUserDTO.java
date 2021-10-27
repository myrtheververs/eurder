package com.switchfullyselfevaluation.eurder.services.dtos;

import com.switchfullyselfevaluation.eurder.domain.user.Address;

public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;

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

    public CreateUserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CreateUserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public CreateUserDTO setEmail(String email) {
        this.email = email;
        return this;

    }

    public CreateUserDTO setAddress(Address address) {
        this.address = address;
        return this;

    }

    public CreateUserDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;

    }
}
