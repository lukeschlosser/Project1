package com.techelevator.Items;

import java.math.BigDecimal;

public class Chips extends Item{

   /* private String name;
    private Double price;
    private int quantity;*/
    private String sound;

    //constructor
    public Chips(String slotLocation, String name, Double price, String type){
        super(slotLocation, name, price, type);
        this.sound = "Crunch Crunch, Yum!";
    }

    //getters

    public String getSound() {
        return sound;
    }

}
