package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    public Inventory(){}

    public List<Item> getInventoryList() {
        String path = "vendingmachine.csv";
        File itemFile = new File(path);
        String[] itemData;

        List<Item> inventoryList = new ArrayList();
        try (Scanner input = new Scanner(itemFile)) {
            while (input.hasNext()) {
                String lineOfText = input.nextLine();
                itemData = lineOfText.split("\\|");
                Item item = new Item(itemData[0], itemData[1], Double.parseDouble(itemData[2]), itemData[3]);
                inventoryList.add(item);    // quantity = 5
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

}
