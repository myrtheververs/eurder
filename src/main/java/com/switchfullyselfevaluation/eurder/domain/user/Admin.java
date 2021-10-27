package com.switchfullyselfevaluation.eurder.domain.user;

public class Admin extends User {

    private final UserRole userRole;

    public Admin(String firstName, String lastName, String email, Address address, String phoneNumber, UserRole userRole) {
        super(firstName, lastName, email, address, phoneNumber);

        this.userRole = UserRole.ADMIN;
    }

    public UserRole getUserRole() {
        return userRole;
    }
}
