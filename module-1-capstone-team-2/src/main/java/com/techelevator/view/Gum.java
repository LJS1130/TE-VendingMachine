package com.techelevator.view;

import java.math.BigDecimal;

public class Gum extends Product{

    public Gum(String slotId, String name, BigDecimal price, String type) {
        super(slotId, name, price, type);
    }
    public Gum(){
        super();
    }
    @Override
    public String getSound() {
        return "Chew Chew, Yum!";
    }
}
