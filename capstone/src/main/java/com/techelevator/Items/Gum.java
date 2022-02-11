package com.techelevator.Items;


public class Gum extends Item{

    /*private String name;
    private Double price;
    private int quantity;*/
    private String sound;

    //constructor
    public Gum(String slotLocation, String name, Double price, String type){
        super(slotLocation, name, price, type);
        this.sound = "Chew Chew, Yum!";
    }

    //getters

    public String getSound() {
        return sound;
    }
}
