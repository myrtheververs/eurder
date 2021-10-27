package com.switchfullyselfevaluation.eurder.domain.user;

public class Customer extends User {

    private final UserRole userRole;

    public Customer(String firstName, String lastName, String email, Address address, String phoneNumber) {
        super(firstName, lastName, email, address, phoneNumber);

        userRole = UserRole.CUSTOMER;
    }

    public UserRole getUserRole() {
        return userRole;
    }


}
