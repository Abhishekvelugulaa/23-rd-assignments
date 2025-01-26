package com.projectday23;
//7. Inventory Management SystemDescription: Track products and stock levels for a small business.

//Features:Classes: Product, Supplier, Inventory.Methods: Add/update/remove products, low-stock alerts.Use interfaces for supplier-related operations.

import java.util.*;

interface SupplierOperations {
    void addSupplier(String name);
    void listSuppliers();
}

class Item {
    private int id;
    private String name;
    private int stock;

    public Item(int id, String name, int stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getStock() { return stock; }

    public void updateStock(int quantity) {
        this.stock += quantity;
    }

    @Override
    public String toString() {
        return "Item [ID=" + id + ", Name=" + name + ", Stock=" + stock + "]";
    }
}

class Inventory implements SupplierOperations {
    private List<Item> items = new ArrayList<>();
    private List<String> suppliers = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void updateItemStock(int itemId, int quantity) {
        for (Item item : items) {
            if (item.getId() == itemId) {
                item.updateStock(quantity);
                return;
            }
        }
        System.out.println("Item not found!");
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getId() == itemId);
    }

    public void checkLowStock() {
        for (Item item : items) {
            if (item.getStock() < 5) {
                System.out.println("Low stock alert: " + item);
            }
        }
    }

    @Override
    public void addSupplier(String name) {
        suppliers.add(name);
    }

    @Override
    public void listSuppliers() {
        System.out.println("Suppliers: " + suppliers);
    }
}

public class Q7inventory {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Item i1 = new Item(1, "Chair", 10);
        Item i2 = new Item(2, "Table", 3);
        inventory.addItem(i1);
        inventory.addItem(i2);

        inventory.updateItemStock(2, -2); // Reducing stock
        inventory.checkLowStock();

        inventory.addSupplier("ABC Supplies");
        inventory.listSuppliers();

        inventory.removeItem(1); // Removing an item
        System.out.println("Item with ID 1 removed.");
    }
}
