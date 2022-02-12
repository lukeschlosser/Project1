package com.techelevator;

import com.techelevator.inventory.Inventory;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    private Double balance;
    private Inventory inventory;
    private List<Inventory> inventoryList;
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
        inventoryList = inventory.getInventoryList();
        for (Inventory inv : inventoryList) {
            if (inv.getQuantity() == 0) {
                System.out.println("It is SOLD OUT.");
            } else {
                System.out.println(inv.getItem().getSlotLocation() + " " + inv.getItem().getName() + " $" + String.format("%.2f", inv.getItem().getPrice()) + " " + inv.getQuantity() + " out of 5 remaining");
            }
        }
    }

    public Boolean makeDeposit(String deposit) {
        Double convertToDB = Double.parseDouble(deposit.substring(1));
        String msg = "";
        if (balance == 0) {
            balance = convertToDB;
            msg = "FEED MONEY: $" + String.format("%.2f", (balance));
        } else {
            msg = "FEED MONEY: $" + String.format("%.2f", (balance)) + " $" + String.format("%.2f", (balance + convertToDB));
            balance += convertToDB;
        }
        System.out.println(" Current Money Provided: $" + String.format("%.2f", balance));

        try {
            appLog.log(msg);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }
        return true;
    }

    public boolean selectProduct(String productCode) {
        boolean successful;
        String msg = "";
        Inventory inv = inventory.searchInventory(productCode);
        if (inv==null) {
            System.out.println("The product code does not exist.");
            successful = false;
        } else if (inv.getQuantity() == 0) {
            System.out.println("It is sold out.");
            successful = false;
        } else {
            Double remaining = balance - inv.getItem().getPrice();
            msg = inv.getItem().getName()+" "+inv.getItem().getSlotLocation()+" $"+String.format("%.2f",balance)+" $"+String.format("%.2f",remaining);
            balance = remaining;
            inv.updateInventory(inv);
            System.out.println(inv.getItem().getName() + ", $" + inv.getItem().getPrice() + ", remaining: $" + remaining);
            System.out.println(soundMap.get(inv.getItem().getType()));
            successful = true;
        }

        try {
            appLog.log(msg);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }

        return successful;
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
}
