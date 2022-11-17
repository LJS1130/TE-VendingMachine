package com.techelevator.view;

import java.math.BigDecimal;

public class Drink extends Product {
    public Drink(String slotId, String name, BigDecimal price, String type) {
        super(slotId, name, price, type);
    }

    public Drink(){
        super();
    }

    @Override
    public String getSound(){
        return "Glug Glug, Yum!";
    }

}
