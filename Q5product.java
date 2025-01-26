package com.projectday23;
//5. E-commerce Product ManagementDescription: Manage products, customers, and orders in an e-commerce setting.

//Features:classes: Product, Order, Customer.Methods: Add/remove products, create orders, calculate total cost.

import java.io.*;
import java.util.*;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product [ID=" + id + ", Name=" + name + ", Price=" + price + "]";
    }
}

class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Customer [ID=" + id + ", Name=" + name + "]";
    }
}

class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products = new ArrayList<>();

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalCost() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void saveOrderHistory() throws IOException {
        FileWriter writer = new FileWriter("order_history.txt", true);
        writer.write("Order ID: " + orderId + ", Customer: " + customer.getName() + "\n");
        for (Product product : products) {
            writer.write(product + "\n");
        }
        writer.write("Total Cost: " + calculateTotalCost() + "\n\n");
        writer.close();
    }
}

public class Q5product {
    public static void main(String[] args) {
        try {
            Product p1 = new Product(1, "mac", 50000);
            Product p2 = new Product(2, "mi", 20000);
            Customer customer = new Customer(1, "John Doe");
            Order order = new Order(101, customer);

            order.addProduct(p1);
            System.out.println(p1);
            order.addProduct(p2);
            System.out.println(p2);

            System.out.println("Total Cost: " + order.calculateTotalCost());
            order.saveOrderHistory();
        } catch (IOException e) {
            System.out.println("Error saving order history: " + e.getMessage());
        }
    }
}