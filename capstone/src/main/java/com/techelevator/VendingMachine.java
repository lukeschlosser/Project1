package com.techelevator;

import Items.Inventory;
import Items.Item;

import java.util.List;

public class VendingMachine {

   private Inventory inventory;
   private List<Item> itemList;

   public VendingMachine(){
      this.inventory = new Inventory();
      this.itemList = this.inventory.getItemList();

   }

}
