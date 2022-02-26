package com.techelevator;

import com.techelevator.exceptions.InsufficientFundsException;
import com.techelevator.exceptions.InvalidSlotException;
import com.techelevator.exceptions.SoldOutException;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class VendingMachine {

    private Inventory inventory = new Inventory();
    private static Logger appLog = new Logger();
    // private static final DecimalFormat df = new DecimalFormat("##.00");
    private Map<String, String> soundMap;
    private BigDecimal balance;

    public VendingMachine() {
        this.balance = new BigDecimal("0").setScale(2);
        this.createSoundMap();
    }

    public void listItems() {
        List<Item> inventoryList = inventory.getInventoryList();

        for (Item item : inventoryList) {
            if (item.getQuantity() == 0) {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + item.getPrice() + " SOLD OUT");
            } else {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + item.getPrice() + " " + item.getQuantity() + " out of 5 remaining");
            }
        }
    }

    public void makeDeposit(String deposit) {
        BigDecimal convertToDB = (!deposit.equals("")) ? new BigDecimal(deposit.substring(1)).setScale(2) : new BigDecimal("0").setScale(2);

        balance=balance.add(convertToDB);
        String msg = "FEED MONEY: $" + balance + " $" + balance;
        System.out.println(" Current Money Provided: $" + balance);

        try {
            appLog.log(msg);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException" + e.getMessage());
        }
    }

    public void selectProduct(String productCode) throws InvalidSlotException, InsufficientFundsException, SoldOutException {
        String msg = "";
        Item item = inventory.searchInventory(productCode);
        if (item == null) {
            throw new InvalidSlotException("An invalid product code. You must provide a valid product code.");
        } else if (item.getQuantity() == 0) {
            throw new SoldOutException(productCode+" is sold out.");
        } else {
            BigDecimal remaining = balance.subtract(item.getPrice()).setScale(2);
            if(remaining.signum()>=0) {
                msg = item.getName() + " " + item.getSlotLocation() + " $" + balance + " $" + remaining;
                balance = remaining;    // update balance
                inventory.updateInventory(item);   // update inventory
                System.out.println(item.getName() + " $" + item.getPrice() + " remaining: $" + remaining);
                System.out.println(soundMap.get(item.getType()));
            }else { throw new InsufficientFundsException("Insufficient Balance. Your balance is "+balance);}
        }

        try {
            if (msg != "") {
                appLog.log(msg);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }
    }

    public void closeBank() {
        CoinBox.getInstance().giveChange(balance);
        String msg = "GIVE CHANGE: $" + balance + " $0.00";
        try {
            appLog.log(msg);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }
        balance = new BigDecimal("0").setScale(2);
    }

    public void exitDialog() {
        System.out.println("Thank you! Have a good day!");
    }

    public void getAvailableItems() {
        List<Item> inventoryList = inventory.getInventoryList();

        for (Item item : inventoryList) {
            if (item.getQuantity() != 0) {
                System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + item.getPrice() + " " + item.getQuantity() + " out of 5 remaining");
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
}
