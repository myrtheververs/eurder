package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.user.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private final Map<String, User> usersById ;

    Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository() {
        usersById = new HashMap<>();

        //test data
        Admin admin = new Admin("Ad", "Min", "name@admin.com", new Address("Adminstreet 1", "9000", "Gent"), "0001112223");
        Customer customer = new Customer("Cus", "Tomer", "customer@skynet.com", new Address("Customerstreet 2", "8000", "Brugge"), "05648795");
        Customer customer2 = new Customer("Cos", "Tomson", "cos@skynet.com", new Address("Customerstreet 3", "8000", "Brugge"), "05555795");

        usersById.put(admin.getUuid(), admin);
        usersById.put(customer.getUuid(), customer);
        usersById.put(customer2.getUuid(), customer2);
        logger.warn("admin: " + admin.getUuid());
        logger.warn("customer: " + customer.getUuid());
        logger.warn("customer: " + customer2.getUuid());
    }


    public Customer createCustomer(Customer customer) {
       usersById.put(customer.getUuid(), customer);
       return customer;
    }

    public List<User> getAll() {
        return new ArrayList<>(usersById.values());
    }


    public Map<String, User> getUsersById() {
        return usersById;
    }



    public User addUser(User user) {
        usersById.put(user.getUuid(), user);
        return user;
    }

    public boolean contains(String uuidUser) {
        return usersById.containsKey(uuidUser);
    }

}
