package com.switchfullyselfevaluation.eurder.domain.user;

public class Admin extends User {

    private final UserRole userRole = UserRole.ADMIN;

    public Admin(String firstName, String lastName, String email, Address address, String phoneNumber) {
        super(firstName, lastName, email, address, phoneNumber);
    }

    @Override
    public UserRole getUserRole() {
        return userRole;
    }
}
