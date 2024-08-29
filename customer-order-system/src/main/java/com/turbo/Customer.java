package com.turbo;

public class Customer extends AbstractClass {

    //Create new customer
    public void createCustomer(String name) {
        String sql = "INSERT INTO customers (name) VALUES (?)";
        create(sql, name);
    }

    public void readCustomers() {
        String sql = "SELECT * FROM customers";
        read(sql, rs -> {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        });
    }

    public void updateCustomerName (int id, String newName) {
        String sql = "UPDATE customers SET name = ? WHERE id = ?";
        update(sql, newName, id);
    }

    public void deleteCustomer (int id) {
        String sql = "DELETE FROM customers WHERE id = ?";
        delete(sql, id);
    }
}
