package com.techelevator.Items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    //A product that has run out must indicate that it is SOLD OUT.

    private String name;
    private int stockAmount;
    private String slotLocation; // productCode
    private List<Item> itemList;
    private Item item;

    //constructor
    public Inventory(){
        itemList= this.getItemList();

    }

    //The vending machine is automatically restocked each time the application runs.
    public void addInventory(Item item){

    }

    // When user purchase an item or items.
    public void updateInventory(Item item){

    }

    // check the item whether it is an available or not
    public Item searchInventory(String productCode){
        List<Item> itemList= this.getItemList();
        Item returnedItem= new Item();
       for(Item item: itemList){
           if(item.getSlotLocation().equalsIgnoreCase(productCode)){
               returnedItem = item;
           }
       }
//        System.out.println("searchInventory: "+returnedItem.getName()+" "+String.format("%.2f", returnedItem.getPrice()));
        return returnedItem;
    }

    // get ItemList , but there is no quantity.
    public List<Item> getItemList(){
        String path = "vendingmachine.csv";
        File itemFile = new File(path);
        String [] itemData = new String[]{};

        List<Item> stockList = new ArrayList();
        try(Scanner input = new Scanner(itemFile)){
            while(input.hasNext()){
                String lineOfText = input.nextLine();
                itemData = lineOfText.split("\\|");
                item = new Item(itemData[0],itemData[1], Double.parseDouble(itemData[2]),itemData[3]);
                stockList.add(item);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return stockList;
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
}
