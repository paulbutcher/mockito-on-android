package com.example;

import java.util.HashMap;

public class RealWarehouse implements Warehouse {

    public RealWarehouse() {
        products = new HashMap<String, Integer>();
        products.put("Talisker", 5);
        products.put("Lagavulin", 2);
    }

    public boolean hasInventory(String product, int quantity) {
        return inStock(product) >= quantity;
    }

    public void remove(String product, int quantity) {
        products.put(product, inStock(product) - quantity);
    }

    private int inStock(String product) {
        Integer quantity = products.get(product);
        return quantity == null ? 0 : quantity;
    }

    private HashMap<String, Integer> products;
}
