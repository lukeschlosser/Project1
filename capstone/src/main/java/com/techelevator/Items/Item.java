package com.techelevator.Items;


public class Item {

    private String slotLocation;
    private String name;
    private Double price;
    private String type;
    private int quantity= 5;


    //constructor
    public Item(){}

    public Item(String slotLocation, String name, Double price, String type) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
//        this.quantity = quantity;

    }

    //getters
    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public int getQuantity() {
        return quantity;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public void setQuantity(int i){
        quantity= quantity-i;
    }

}
