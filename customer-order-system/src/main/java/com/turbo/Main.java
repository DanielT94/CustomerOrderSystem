package com.turbo;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Item item = new Item();
        Order order = new Order();

        customer.readCustomers();
        item.readItems();
        order.readOrders();
        order.deleteItemFromOrder(1, 3);
    }

}
