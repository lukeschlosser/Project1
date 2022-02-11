package com.techelevator.Items;

import java.math.BigDecimal;

public class Gum extends Item{

    private String name;
    private BigDecimal price;
    private int quantity;

    //constructor
    public Gum(String name, BigDecimal price){
        this.name = name;
        this.price = price;
        this.quantity = 5;
    }

    //getters
    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

}
