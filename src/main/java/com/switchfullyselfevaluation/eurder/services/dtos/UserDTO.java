package com.switchfullyselfevaluation.eurder.services.dtos;

import com.switchfullyselfevaluation.eurder.domain.user.Address;

public class UserDTO {
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


    public UserDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDTO setAddress(Address address) {
        this.address = address;
        return this;
    }

    public UserDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
