package com.techelevator;

import com.techelevator.Items.Inventory;
import com.techelevator.Items.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

   private Inventory inventory;
   private List<Item> itemList;

   public VendingMachine(){
      this.inventory = new Inventory();
      this.itemList = this.inventory.getItemList();
   }

   public void displayItems() {
//    String itemName;
//    int price;
//    List<>
      Map<String, Integer> itemMap = new HashMap<>();
      for(Item item : itemList) {
         System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + item.getPrice() + /*+ quantity*/ " out of 5 remaining");
      }
   }

   public void finishTransaction() {
      System.out.println("Thank you! Have a good day!");
      System.exit(1);
   }

   public void feedMoney(String choice) {
      System.out.println("You feed "+choice+".");

   }

   public void selectProduct() {

   }
}
