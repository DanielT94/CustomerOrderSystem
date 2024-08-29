package com.turbo;

public class Item extends AbstractClass {

    //Create new item
    public void createItem(String name, double value) {
        String sql = "INSERT into items (name, value) VALUES (?, ?)";
        create(sql, name, value);
    }

    public void readItems() {
        String sql = "SELECT * FROM items";
        read(sql, rs -> {
            System.out.println("Item ID: " + rs.getInt("id") + " Name: " + rs.getString("name") + " Value: " + rs.getDouble("value"));
        });
    }

    public void updateItem(int id, String newName, double newValue) {
        String sql = "UPDATE items SET name = ?, value = ? WHERE id =?";
        update(sql, newName, newValue, id);
    }

    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        delete(sql, id);
    }
}
