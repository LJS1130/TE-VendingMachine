package com.techelevator.view;

import java.math.BigDecimal;

public class Chip extends Product {
    public Chip(String slotId, String name, BigDecimal price, String type) {
        super(slotId, name, price, type);
    }

    public Chip() {
        super();
    }
    @Override
    public String getSound() {
        return "Crunch Crunch, Yum!";
    }
}
