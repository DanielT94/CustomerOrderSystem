package com.turbo;

import java.util.Scanner;


public class CLI {

    private Customer customer;
    private Item item;
    private Order order;
    private Scanner scanner;

    public CLI() {
        customer = new Customer();
        item = new Item();
        order = new Order();
        scanner = new Scanner(System.in);
    }

    public void start() { //start method to be called in main, will handle the user inputs and allow them to perform the methods
        while (true) {
            showMenu(); //When program start display the menu
            int choice = scanner.nextInt(); //accept the users choice from the menu
            scanner.nextLine();

            switch(choice) { //switch statement allows user to select the method they want
                case 1: //create customer
                    System.out.println("Enter customer name: ");
                    customer.createCustomer(scanner.nextLine());
                    break;

                case 2: //read customers
                    customer.readCustomers();
                    break;

                case 3: //update customer
                    System.out.println("Enter customer ID: ");
                    int custID = scanner.nextInt(); //get the customers ID
                    scanner.nextLine(); //skip the /n
                    System.out.println("Enter the customers new name: ");
                    customer.updateCustomerName(custID, scanner.nextLine()); //perform update customer method - passing in user inputted ID and new name
                    break;

                case 4: //delete customer
                    System.out.println("Enter customer ID: ");
                    customer.deleteCustomer(scanner.nextInt()); //delete the customer with inputted ID
                    break;

                case 5: //creat item
                    System.out.println("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.println("Enter item value: ");
                    Double itemValue = scanner.nextDouble();
                    scanner.nextLine(); //skip /n
                    item.createItem(itemName, itemValue); //create item with input name and value
                    break;

                case 6: //read items
                    item.readItems();
                    break;

                case 7: //update item
                    System.out.println("Enter item ID: ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the items new name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the items new value: ");
                    Double newValue = scanner.nextDouble();
                    scanner.nextLine();
                    item.updateItem(itemId, newName, newValue); //update item with input name and value
                    break;

                case 8: //delete item
                    System.out.println("Enter item ID: ");
                    item.deleteItem(scanner.nextInt());
                    break;

                case 9: //create order
                    System.out.println("Enter customer ID: ");
                    order.createOrder(scanner.nextInt());
                    break;

                case 10: //read orders
                    order.readOrders();
                    break;

                case 11: //delete order
                    System.out.println("Enter order ID: ");
                    order.deleteOrder(scanner.nextInt());
                    break;

                case 12: //add item to order
                    System.out.print("Enter order ID: ");
                    int orderId = scanner.nextInt();
                    System.out.print("Enter item ID to add: ");
                    int addItemId = scanner.nextInt();
                    order.addItemToOrder(orderId, addItemId);
                    break;

                case 13: //delete item from order
                    System.out.println("Enter order ID: ");
                    int deleteOrderId = scanner.nextInt();
                    System.out.print("Enter item ID to delete: ");
                    int deleteItemId = scanner.nextInt();
                    order.deleteItemFromOrder(deleteOrderId, deleteItemId);
                    break;

                case 14:
                    System.out.println("Exiting");
                    return;

                default:
                    System.out.println("Incorrect input, please try again");
            }
        }

    }

    private void showMenu() {
        System.out.println("\n1. Add a customer");
        System.out.println("2. View all customers");
        System.out.println("3. Update a customer");
        System.out.println("4. Delete a customer");
        System.out.println("5. Add an item");
        System.out.println("6. View all items");
        System.out.println("7. Update an item");
        System.out.println("8. Delete an item");
        System.out.println("9. Create an order");
        System.out.println("10. View all orders");
        System.out.println("11. Delete an order");
        System.out.println("12. Add an item to an order");
        System.out.println("13. Delete an item from an order");
        System.out.println("14. Exit");
        System.out.print("Please select an option: ");
    }
}
