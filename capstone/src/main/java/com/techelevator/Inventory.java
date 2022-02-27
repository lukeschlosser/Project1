package com.techelevator;

import com.techelevator.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Product> inventoryList;

    public Inventory() {
        this.inventoryList = this.getCSVList();
    }

    public List<Product> getInventoryList() {
        return inventoryList;
    }

    public Product searchInventory(String productCode) {
        Product searchedProduct = null;
        for (Product product : inventoryList) {
            if (product.getSlotLocation().equalsIgnoreCase(productCode)) {
                searchedProduct = product;
            }
        }
        return searchedProduct;
    }

    public void updateInventory(Product productUpdated) {
        for (Product product : inventoryList) {
            if (product.getSlotLocation().equals(productUpdated.getSlotLocation())) {
                product.setQuantity(product.getQuantity() - 1);
            }
        }
    }

    private List<Product> getCSVList() {

        inventoryList = new ArrayList();
        try (Scanner input = new Scanner(new File("vendingmachine.csv"))) {
            while (input.hasNext()) {
                String lineOfText = input.nextLine();
                String[] itemData = lineOfText.split("\\|");
                Product product = new Product(itemData[0],
                        itemData[1],
                        new BigDecimal(itemData[2]).setScale(2), // change to BigDecimal
                        itemData[3]);
                inventoryList.add(product);    // quantity = 5
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }
}
