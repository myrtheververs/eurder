package com.switchfullyselfevaluation.eurder.domain.repository;

import com.switchfullyselfevaluation.eurder.domain.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, User> usersById;
    Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository() {
        this.usersById = new HashMap<>();

        User admin = new User("Ann", "Min", "anmin@gmail.com",
                new Address("Hoofdstraat 1", "9000", "Gent"),
                "00324949494",
                UserRole.ADMIN);
        User customer = new User("Myrthe", "Ververs", "myrthe@gmail.com",
                new Address("Zijstraat 2", "9000", "Gent"),
                "00324555512",
                UserRole.CUSTOMER);
        usersById.put(admin.getId(), admin);
        usersById.put(customer.getId(), customer);
        logger.warn("Admin: " + admin.getId());
        logger.warn("Customer: " + customer.getId());
    }


    // STORY 1: register customer
    public void registerCustomer(User user) {
        usersById.put(user.getId(), user);
        logger.info(String.format("UserRepository: customer %s registered", user.getId()));
    }

    // STORY 7: view all customers as admin
    public List<User> getUsers() {
        return new ArrayList<>(usersById.values());
    }

    //STORY 2 & 8
    public User getUser(String userId) {
        return usersById.get(userId);
    }


    // Helper methods
    public boolean isAdmin(String userId) {
        return usersById.get(userId).getUserRole() == UserRole.ADMIN;
    }

    public boolean isCustomer(String userId) {
        return usersById.get(userId).getUserRole() == UserRole.CUSTOMER;
    }

    public void addUser(User user) {
        usersById.put(user.getId(), user);
    }
}

