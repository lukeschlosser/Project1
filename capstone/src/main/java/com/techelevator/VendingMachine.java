package com.techelevator;

import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {

    private Double balance;
    private Inventory inventory;
    private List<Item> inventoryList;
    private static Logger appLog = new Logger();
    private Map<String, String> soundMap;

    public VendingMachine() {
        this.balance = 0.00;
        this.inventory = new Inventory();
        this.createSoundMap();
    }

    public void createSoundMap() {
        this.soundMap = new HashMap<>();
        soundMap.put("Chip", "Crunch Crunch, Yum!");
        soundMap.put("Candy", "Munch Munch, Yum!");
        soundMap.put("Drink", "Glug Glug, Yum!");
        soundMap.put("Gum", "Chew Chew, Yum!");
    }

    public void listItems() {
        if(inventoryList== null) {
            inventoryList = inventory.getInventoryList();  // start
        }
        for (Item item : inventoryList) {
            if (item.getQuantity() == 0) {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + String.format("%.2f", item.getPrice()) + " SOLD OUT");
            } else {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + String.format("%.2f", item.getPrice()) + " " + item.getQuantity() + " out of 5 remaining");
            }
        }
    }

    public Boolean makeDeposit(String deposit) {
        boolean successful;
        Double convertToDB = Double.parseDouble(deposit.substring(1));
        String msg = "";
        if (balance == 0) {
            balance = convertToDB;
            msg = "FEED MONEY: $" + String.format("%.2f", (balance))+" $"+ String.format("%.2f", (balance));
        } else {
            msg = "FEED MONEY: $" + String.format("%.2f", (balance)) + " $" + String.format("%.2f", (balance + convertToDB));
            balance += convertToDB;
        }
        System.out.println(" Current Money Provided: $" + String.format("%.2f", balance));

        try {
            appLog.log(msg);
            successful=true;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
            successful =false;
        }
        return successful;
    }

    public boolean selectProduct(String productCode) {
        boolean successful;
        String msg = "";
        Item item = this.searchInventory(productCode);
        if (item==null) {
            System.out.println("The product code does not exist.");
            successful = false;
        } else if (item.getQuantity() == 0) {
            System.out.println("It is sold out.");
            successful = false;
        } else {
            Double remaining = balance - item.getPrice();
            msg = item.getName()+" "+item.getSlotLocation()+" $"+String.format("%.2f",balance)+" $"+String.format("%.2f",remaining);
            balance = remaining;    // update balance
            item.setQuantity(item.getQuantity()-1); // update inventory
            System.out.println(item.getName() + " $" + item.getPrice() + " remaining: $" + remaining);
            System.out.println(soundMap.get(item.getType()));
            successful = true;
        }

        try {
            if(msg!="") {
                appLog.log(msg);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }

        return successful;
    }

    private Item searchInventory(String productCode) {
        Item inventoryItem=null;
        for(Item item: inventoryList){
            if(item.getSlotLocation().equalsIgnoreCase(productCode)){
                inventoryItem = item;
            }
        }
        return inventoryItem;
    }

    public void closeBank() {
        CoinBox cb = new CoinBox();
        cb.giveChange(balance);
        String msg = "GIVE CHANGE: $"+String.format("%.2f",balance)+" $0.00";
       try {
          appLog.log(msg);
       } catch (FileNotFoundException e) {
          System.out.println("FileNotFoundException " + e.getMessage());
       }
        balance = 0.00;
    }

    public void exitDialog() {
        System.out.println("Thank you! Have a good day!");
    }

    public void availableItems() {
        if(inventoryList== null) {
            inventoryList = inventory.getInventoryList();  // start
        }
        for (Item item : inventoryList) {
            if (!(item.getQuantity() == 0)) {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + String.format("%.2f", item.getPrice()) + " " + item.getQuantity() + " out of 5 remaining");
            }
        }
    }
}
