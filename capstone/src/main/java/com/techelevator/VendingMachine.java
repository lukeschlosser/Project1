package com.techelevator;

import com.techelevator.Items.Inventory;
import com.techelevator.Items.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
//The vending machine is automatically restocked each time the application runs.
   private Inventory inventory;
   private List<Item> itemList;
   private Item item;
   private Double balance;

   public VendingMachine(){
      this.inventory = new Inventory();
      this.itemList = this.inventory.getItemList();
      balance = 0.00;
   }
/*When the customer selects "(1) Display Vending Machine Items", they're presented with a list of all items in the vending machine with its quantity remaining:
Each vending machine product has a slot identifier and a purchase price.
Each slot in the vending machine has enough room for 5 of that product.
Every product is initially stocked to the maximum amount.
A product that has run out must indicate that it is SOLD OUT.*/
   public void listItems() {
      Map<String, Integer> itemMap = new HashMap<>();
      for(Item item : itemList) {
         System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + String.format("%.2f", item.getPrice()) + " " + item.getQuantity() + " out of 5 remaining");
      }
   }

   public Boolean makeDeposit(String deposit) {
      Double convertToDB = Double.parseDouble(deposit.substring(1));

      if(balance==0){ // if there is no balance
         balance = convertToDB;
      }else{
         balance+=convertToDB;
      }
      System.out.println(" Current Money Provided: $"+String.format("%.2f",balance));

      // update log.txt (ex.01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00 )
      return true; // temporary
   }

   public void selectProduct(String productCode) {
      System.out.println("productCode: "+productCode);
      item = inventory.searchInventory(productCode);
      if(item.equals(null)){
         System.out.println("The product code does not exist.");
      }

      Double remaining = balance - item.getPrice();
      balance=remaining;

     item.setQuantity(1);

      System.out.println(item.getName()+", $"+item.getPrice()+", remaining: $"+ remaining);
   }

   /*
If the product code does not exist, the customer is informed and returned to the Purchase menu.
If a product is sold out, the customer is informed and returned to the Purchase menu.
If a valid product is selected, it is dispensed to the customer.
Dispensing an item prints the item name, cost, and the money remaining. Dispensing also returns a sound
After the product is dispensed, the machine must update its balance accordingly and return the customer to the Purchase menu.
      * */

   public void closeBank() {
      CoinBox cb = new CoinBox();
      cb.giveChange(balance);
      balance = 0.00;

      /*  Each purchase must generate a line in a file called Log.txt.
      ex. 01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00*/
   }

   public void exitDialog() {
      System.out.println("Thank you! Have a good day!");
   }

//   public void printBalance(){
//      System.out.println(" Current Money Provided: $"+balance);
//   }
}
