package com.switchfullyselfevaluation.eurder.domain.user;

import com.switchfullyselfevaluation.eurder.exceptions.InvalidUserException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.UUID;

public abstract class User {

    private final String uuid;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final String phoneNumber;
    private UserRole userRole;


    public User(String firstName, String lastName, String email, Address address, String phoneNumber ,UserRole userRole) {
        this.uuid = UUID.randomUUID().toString();
        this.firstName = firstNameNotNull(firstName);
        this.lastName = lastName;
        this.email = isValidEmailAddress(email);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.userRole = userRole;
    }

    public User(String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.uuid = UUID.randomUUID().toString();
        this.firstName = firstNameNotNull(firstName);
        this.lastName = lastName;
        this.email = isValidEmailAddress(email);
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

    public UserRole getUserRole() {
        return userRole;
    }


    public String firstNameNotNull(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cant be null.");
        } else {
            return lastName;
        }
    }

    public String isValidEmailAddress(String email) {
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            throw new InvalidUserException("Not a valid email-address");
        }
        return email;
    }
}
