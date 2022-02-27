package com.techelevator;


import java.math.BigDecimal;

public class Product {

    private String slotLocation;
    private String name;
    private BigDecimal price;
    private String type;
    private int quantity;

    public Product() {
    }

    public Product(String slotLocation, String name, BigDecimal price, String type) {
        this.slotLocation = slotLocation;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
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

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }
}
