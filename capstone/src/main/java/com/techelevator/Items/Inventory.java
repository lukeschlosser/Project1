package com.techelevator.Items;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
//        The vending machine is automatically restocked each time the application runs.
//        A product that has run out must indicate that it is SOLD OUT.

    private String name;
    private int stockAmount;
    private String slotLocation;
    private Item item;

    //constructor
    public Inventory(){

    }

    //getters
    public String getName() {
        return name;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public List<Item> getItemList(){
        String path = "vendingmachine.csv";
        File itemFile = new File(path);
        String [] itemData = new String[]{};

        List<Item> stockList = new ArrayList();
        try(Scanner input = new Scanner(itemFile)){
            while(input.hasNext()){
                String lineOfText = input.nextLine();
                itemData = lineOfText.split("\\|");
                item = new Item(itemData[0],itemData[1], new BigDecimal(itemData[2]),itemData[3]);
                stockList.add(item);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stockList;
    }

}
