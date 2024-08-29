package com.turbo;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();

        customer.readCustomers();
        customer.deleteCustomer(1);
        customer.readCustomers();
    }

}
