package com.switchfullyselfevaluation.eurder.domain.repositories;

import com.switchfullyselfevaluation.eurder.domain.user.Address;
import com.switchfullyselfevaluation.eurder.domain.user.Admin;
import com.switchfullyselfevaluation.eurder.domain.user.Customer;
import com.switchfullyselfevaluation.eurder.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, User> usersById ;

    Logger logger = LoggerFactory.getLogger(UserRepository.class);

    public UserRepository() {
        usersById = new HashMap<>();

        //test data
        Admin admin = new Admin("Ad", "Min", "name@admin.com", new Address("Adminstreet 1", "9000", "Gent"), "0001112223");
        Customer customer = new Customer("Cus", "Tomer", "customer@skynet.com", new Address("Customerstreet 2", "8000", "Brugge"), "05648795");
        usersById.put(admin.getUuid(), admin);
        usersById.put(customer.getUuid(), customer);
        logger.warn("admin: " + admin.getUuid());
        logger.warn("customer: " + customer.getUuid());
    }


    public void createCustomer(Customer customer) {
        usersById.put(customer.getUuid(), customer);
    }




    public boolean contains(String uuidUser) {
        return usersById.containsKey(uuidUser);
    }

    public Map<String, User> getUsersById() {
        return usersById;
    }
}
