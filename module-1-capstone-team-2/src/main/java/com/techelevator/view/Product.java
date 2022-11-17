package com.techelevator.view;

import java.math.BigDecimal;

public abstract class Product {
    String slotId;
    String name;
    BigDecimal price;
    String type;
    int quantity;

//TODO private instance variables, constant for quantity

    public Product(String slotId, String name, BigDecimal price, String type) {
        this.slotId = slotId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSlotId() {
        return slotId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getSound();

    @Override
    public String toString(){
        return this.slotId + ": " + this.name + " for $" + this.price + ". " + this.quantity + " remaining in stock.";
    }

}


