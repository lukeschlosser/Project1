package com.techelevator;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

public class VendingMachine {

    private Inventory inventory = new Inventory();
    private static Logger appLog = new Logger();
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private Map<String, String> soundMap;
    private double balance;

    public VendingMachine() {
        this.balance = 0.00;
        this.createSoundMap();
    }

    public void listItems() {
        List<Item> inventoryList = inventory.getInventoryList();

        for (Item item : inventoryList) {
            if (item.getQuantity() == 0) {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + df.format(item.getPrice()) + " SOLD OUT");
            } else {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + df.format(item.getPrice()) + " " + item.getQuantity() + " out of 5 remaining");
            }
        }
    }

    public boolean makeDeposit(String deposit) {
        boolean successful;
        double convertToDB = (deposit!="")?Double.parseDouble(deposit.substring(1)):0;
        String msg;
        if (balance == 0) {
            balance = convertToDB;
            msg = "FEED MONEY: $" + df.format(balance) + " $" + df.format(balance);
        } else {
            msg = "FEED MONEY: $" + df.format(balance) + " $" + df.format(balance + convertToDB);
            balance += convertToDB;
        }
     //   System.out.println(" Current Money Provided: $" + df.format(balance));

        try {
            appLog.log(msg);
            successful = true;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
            successful = false;
        }
        return successful;
    }

    public boolean selectProduct(String productCode) {
        boolean successful;
        String msg = "";
        Item item = inventory.searchInventory(productCode);
        if (item == null) {
            System.out.println("The product code does not exist.");
            successful = false;
        } else if (item.getQuantity() == 0) {
            System.out.println("It is sold out.");
            successful = false;
        } else {
            double remaining = Double.parseDouble(df.format(balance - item.getPrice()));
            msg = item.getName() + " " + item.getSlotLocation() + " $" + df.format(balance) + " $" + df.format(remaining);
            balance = remaining;    // update balance
            inventory.updateInventory(item);   // update inventory
            System.out.println(item.getName() + " $" + item.getPrice() + " remaining: $" + remaining);
            System.out.println(soundMap.get(item.getType()));
            successful = true;
        }

        try {
            if (msg != "") {
                appLog.log(msg);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }

        return successful;
    }

    public void closeBank() {
        CoinBox cb = new CoinBox();
        cb.giveChange(balance);
        String msg = "GIVE CHANGE: $" + df.format(balance) + " $0.00";
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

    public void getAvailableItems() {
        List<Item> inventoryList = inventory.getInventoryList();

        for (Item item : inventoryList) {
            if (item.getQuantity() != 0) {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + df.format(item.getPrice()) + " " + item.getQuantity() + " out of 5 remaining");
            }
        }
    }

    public void createSoundMap() {
        this.soundMap = new HashMap<>();
        soundMap.put("Chip", "Crunch Crunch, Yum!");
        soundMap.put("Candy", "Munch Munch, Yum!");
        soundMap.put("Drink", "Glug Glug, Yum!");
        soundMap.put("Gum", "Chew Chew, Yum!");
    }

    public void viewBalance() {
        if(balance!=0){
            System.out.println(" Current Money Provided: $" + df.format(balance));
        }
    }
}
