package com.example;

public class Order {

    public Order(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void fill(Warehouse warehouse) {
        if (warehouse.hasInventory(product, quantity)) {
            warehouse.remove(product, quantity);
            filled = true;
        }
    }

    public boolean isFilled() {
        return filled;
    }

    private boolean filled = false;
    private String product;
    private int quantity;
}
