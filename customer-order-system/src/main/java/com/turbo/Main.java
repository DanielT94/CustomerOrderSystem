package com.turbo;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.readCustomers();
        customer.updateCustomerName(1, "Jack");
        customer.readCustomers();
    }

}
