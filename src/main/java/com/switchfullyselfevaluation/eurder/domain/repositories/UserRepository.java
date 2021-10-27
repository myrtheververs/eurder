package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, User> usersById ;


    public UserRepository() {
        usersById = new HashMap<>();
    }


    public void createCustomer(Customer customer) {
        usersById.put(customer.getUuid(), customer);
    }

    public boolean contains(String uuidUser) {
        return usersById.containsKey(uuidUser);
    }



}
