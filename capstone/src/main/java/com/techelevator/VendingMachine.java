package com.techelevator;

import com.techelevator.dao.JdbcInvDao;
import com.techelevator.exceptions.InsufficientFundsException;
import com.techelevator.exceptions.InvalidSlotException;
import com.techelevator.exceptions.SoldOutException;
import com.techelevator.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

//@Scope(value = "session")
//@Component(value = "vendingMachine")
public class VendingMachine {

//    private JdbcInvDao jdbcInvDao;
    private Inventory inventory = new Inventory();
    private static Logger appLog = new Logger();
    private BigDecimal balance;
    private Map<String, String> soundMap;

    public VendingMachine() {
        this.balance = new BigDecimal("0").setScale(2);
        this.createSoundMap();
    }

    public void listItems() {
        List<Product> inventoryList = inventory.getInventoryList();

        for (Product product : inventoryList) {
            if (product.getQuantity() == 0) {
                System.out.println(product.getSlotLocation() + " " + product.getName() + " $" + product.getPrice() + " SOLD OUT");
            } else {
                System.out.println(product.getSlotLocation() + " " + product.getName() + " $" + product.getPrice() + " " + product.getQuantity() + " out of 5 remaining");
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
        Product product = inventory.searchInventory(productCode);
        if (product == null) {
            throw new InvalidSlotException("An invalid product code. You must provide a valid product code.");
        } else if (product.getQuantity() == 0) {
            throw new SoldOutException(productCode+" is sold out.");
        } else {
            BigDecimal remaining = balance.subtract(product.getPrice()).setScale(2);
            if(remaining.signum()>=0) {
                msg = product.getName() + " " + product.getSlotLocation() + " $" + balance + " $" + remaining;
                balance = remaining;    // update balance
                inventory.updateInventory(product);   // update inventory
                System.out.println(product.getName() + " $" + product.getPrice() + " remaining: $" + remaining);
                System.out.println(soundMap.get(product.getType()));
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
        List<Product> inventoryList = inventory.getInventoryList();

        for (Product product : inventoryList) {
            if (product.getQuantity() != 0) {
                System.out.println(product.getSlotLocation() + " " + product.getName() + " $" + product.getPrice() + " " + product.getQuantity() + " out of 5 remaining");
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
