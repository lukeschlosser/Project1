package com.techelevator.Items;

import java.math.BigDecimal;

public class Drink extends Item {

    /*private String name;
    private Double price;
    private int quantity;*/
    private String sound;

    //constructor
    public Drink(String slotLocation, String name, Double price, String type){
        super(slotLocation, name, price, type);
        this.sound = "Glug Glug, Yum!";
    }

    //getters

    public String getSound() {
        return sound;
    }
}
