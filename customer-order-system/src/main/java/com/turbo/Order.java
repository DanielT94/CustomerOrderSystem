package com.turbo;

public class Order extends AbstractClass {

    //create new order
    public void createOrder(int customerID) {
        String sql = "INSERT into orders (customer_id) VALUES (?)";
        create(sql, customerID);
    }

    public void readOrders() {
        String sql = "SELECT * FROM orders";
        read(sql, rs -> {
            System.out.println("Order ID: " + rs.getInt("id") + ", CustomerID " + rs.getInt("customer_id"));
        });
    }

    public void deleteOrder(int id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        delete(sql, id);
    }

    public void addItemToOrder(int orderId, int itemId) {
        String sql = "INSERT INTO order_items (order_id, item_id) VALUES (?, ?)";
        create(sql, orderId, itemId);
    }

    public void deleteItemFromOrder(int orderId, int itemId) {
        String sql = "DELETE FROM order_items WHERE order_id = ? AND item_id = ?";
        delete(sql, orderId, itemId);
    }
}
