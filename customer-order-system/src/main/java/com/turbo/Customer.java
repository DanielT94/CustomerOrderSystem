package com.turbo;

public class Customer extends AbstractClass {

    //Create new customer
    public void createCustomer(String name) {
        String sql = "INSERT INTO customers (name) VALUES (?)";
        create(sql, name);
    }
}
