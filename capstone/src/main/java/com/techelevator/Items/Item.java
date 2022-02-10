package com.techelevator.Items;

import java.math.BigDecimal;

public class Item {

    private String slotLocation;
    private String name;
    private int price;
    private String type;

    //constructor
    public Item(){}

    public Item(String slotLocation, String name, BigDecimal price, String type) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price.intValue();
        this.type = type;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }


}
