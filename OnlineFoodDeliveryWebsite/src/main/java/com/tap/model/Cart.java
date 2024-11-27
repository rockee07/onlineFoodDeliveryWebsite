package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    // Add an item to the cart
    public void addItem(CartItem item) {
        int itemId = item.getItemId();
        if (items.containsKey(itemId)) {
            CartItem existItem = items.get(itemId);
            // Update quantity and subtotal for an existing item
            existItem.setQuantity(existItem.getQuantity() + item.getQuantity());
            existItem.setSubTotal(existItem.getPrice() * existItem.getQuantity());
        } else {
            // Add new item to the cart
            items.put(itemId, item);
        }
    }

    // Update an item's quantity and subtotal in the cart
    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            CartItem item = items.get(itemId);

            if (quantity <= 0) {
                // Remove the item if quantity is zero or less
                items.remove(itemId);
            } else {
                // Update the quantity and recalculate the subtotal
                item.setQuantity(quantity);
                item.setSubTotal(item.getPrice() * quantity);
            }
        }
    }

    // Remove an item from the cart
    public void removeItem(int itemId) {
        items.remove(itemId);
    }

    // Get all items in the cart
    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // Clear all items from the cart
    public void clear() {
        items.clear();
    }
}
