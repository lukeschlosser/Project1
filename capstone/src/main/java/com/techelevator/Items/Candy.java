package com.techelevator.Items;

import java.math.BigDecimal;

public class Candy extends Item{

    /*private String name;
    private Double price;
    private int quantity;*/
    private String sound;

    //constructor
    public Candy(String slotLocation, String name, Double price, String type){
        super(slotLocation, name, price, type);
        this.sound = "Munch Munch, Yum!";
    }

    //getters

    public String getSound() {
        return sound;
    }

}
