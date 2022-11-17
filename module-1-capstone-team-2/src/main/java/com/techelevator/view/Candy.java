package com.techelevator.view;

import java.math.BigDecimal;

public class Candy extends Product{

    public Candy(String slotId, String name, BigDecimal price, String type) {
        super(slotId, name, price, type);
    }
    public Candy(){
        super();
    }
    @Override
    public String getSound() {
        return "Munch Munch, Yum!";
    }

}
