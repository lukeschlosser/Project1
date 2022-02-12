package com.techelevator;


public class Item{

    private String slotLocation;
    private String name;
    private Double price;
    private String type;
    private int quantity;


    public Item(String slotLocation, String name, Double price, String type) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;
    }

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

    public int getQuantity() { return quantity;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
