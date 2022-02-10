package com.techelevator;

import Items.Inventory;
import Items.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

   private Inventory inventory;
   private List<String[]> itemList;

   public VendingMachine(){
      this.inventory = new Inventory();
      this.itemList = this.inventory.getItemList();

   }

   public void displayItems() {
//    String itemName;
//    int price;
//    List<>
      Map<String, Integer> itemMap = new HashMap<>();

      for(String[] item : itemList) {


         System.out.println(item[0] + " " + item[1] + " $" + item[2] + /*+ quantity*/ "out of 5 remaining");
      }
   }
}
