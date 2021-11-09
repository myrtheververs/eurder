package com.switchfullyselfevaluation.eurder.domain.user;

import com.switchfullyselfevaluation.eurder.exception.InvalidUserException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.UUID;

public class User {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;
    private final UserRole userRole;

    public User(String firstName, String lastName, String email, Address address, String phoneNumber, UserRole userRole) {
        this.id = UUID.randomUUID().toString();
        this.firstName = isValidFirstName(firstName);
        this.lastName = lastName;
        this.email = isValidEmailAddress(email);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
    }

    //constructor without userrole -> register customer : STORY 1
    public User(String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = isValidFirstName(firstName);
        this.lastName = lastName;
        this.email = isValidEmailAddress(email);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userRole = UserRole.CUSTOMER;
    }

    public String getId() {
        return id;
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

    public UserRole getUserRole() {
        return userRole;
    }




    //helper methods

    public String isValidFirstName(String firstName) {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidUserException("Invalid first name: cant be null or blank");
        } else {
            return firstName;
        }
    }

    //from internet, taken from digybooky project where we used it as well, unknown source
    public String isValidEmailAddress(String email) {
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            throw new InvalidUserException("Invalid email-address");
        }
        return email;
    }
}
