package com.techelevator.Items;

public class Drink extends Item {

    private String name;
    private int price;
    private int quantity;

    //constructor
    public Drink(String name, int price){
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
    public int getPrice() {
        return price;
    }
}
