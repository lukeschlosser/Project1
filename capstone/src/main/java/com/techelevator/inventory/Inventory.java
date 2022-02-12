package com.techelevator.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private int quantity;
    private Item item;
    private List<Inventory> inventoryList;

    public Inventory(){}

    public Inventory(Item item) {
        this.item = item;
        this.quantity = 5;
    }
    // initiation for quantity
    public Inventory(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void addInventory(Item item) {
        //The vending machine is automatically restocked each time the application runs.
    }

    public void updateInventory(Inventory inventory) {
        List<Inventory> inventoryList = this.getInventoryList();
        for(Inventory iv:inventoryList){
            if(iv.getItem().getSlotLocation().equals(inventory.getItem().getSlotLocation())){
                iv.quantity--;
            }
        }
    }

    public Inventory searchInventory(String productCode){
        Inventory inventory=null;

        for(Inventory inv: inventoryList){
           if(inv.getItem().getSlotLocation().equalsIgnoreCase(productCode)){
                inventory = inv;
           }
       }
//        System.out.println("searchInventory: "+returnedItem.getName()+" "+String.format("%.2f", returnedItem.getPrice()));
        return inventory;
    }

    public List<Inventory> getInventoryList() {
        String path = "vendingmachine.csv";
        File itemFile = new File(path);
        String[] itemData;

        inventoryList = new ArrayList();
        try (Scanner input = new Scanner(itemFile)) {
            while (input.hasNext()) {
                String lineOfText = input.nextLine();
                itemData = lineOfText.split("\\|");
                Item item = new Item(itemData[0], itemData[1], Double.parseDouble(itemData[2]), itemData[3]);
                Inventory inventory = new Inventory(item);
                inventoryList.add(inventory);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }
}
