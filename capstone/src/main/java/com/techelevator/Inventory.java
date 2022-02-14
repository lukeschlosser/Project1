package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Item> inventoryList;

    public Inventory() {
        this.inventoryList = this.getCSVList();
    }

    public List<Item> getInventoryList() {
        return inventoryList;
    }

    public Item searchInventory(String productCode) {
        Item searchedItem = null;
        for (Item item : inventoryList) {
            if (item.getSlotLocation().equalsIgnoreCase(productCode)) {
                searchedItem = item;
            }
        }
        return searchedItem;
    }

    public void updateInventory(Item itemUpdated) {
        for (Item item : inventoryList) {
            if (item.getSlotLocation().equals(itemUpdated.getSlotLocation())) {
                item.setQuantity(item.getQuantity() - 1);
            }
        }
    }

    private List<Item> getCSVList() {

        inventoryList = new ArrayList();
        try (Scanner input = new Scanner(new File("vendingmachine.csv"))) {
            while (input.hasNext()) {
                String lineOfText = input.nextLine();
                String[] itemData = lineOfText.split("\\|");
                Item item = new Item(itemData[0],
                        itemData[1],
                        Double.parseDouble(itemData[2]),
                        itemData[3]);
                inventoryList.add(item);    // quantity = 5
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }
}
