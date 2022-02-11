package com.techelevator;

import com.techelevator.Items.Inventory;
import com.techelevator.Items.Item;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
//The vending machine is automatically restocked each time the application runs.
   private Inventory inventory;
   private List<Item> itemList;
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
   public void displayItems() {
      Map<String, Integer> itemMap = new HashMap<>();
      for(Item item : itemList) {
         System.out.println(item.getSlotLocation() + " " + item.getName() + " $" + item.getPrice() + /*+ quantity*/ " out of 5 remaining");
      }
   }

   public Boolean feedMoney(String choice) {
      Double convertToDB = Double.parseDouble(choice.substring(1));

      if(balance==0){ // if there is no balance
         balance = convertToDB;
      }else{
         balance+=convertToDB;
      }
      System.out.println(" Current Money Provided: $"+String.format("%.2f",balance));

      // update log.txt (ex.01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00 )
      return true; // temporary
   }

   public void selectProduct() {
/*
Selecting "(2) Select Product" allows the customer to select a product to purchase.
Show the list of products available and allow the customer to enter a code to select an item.
If the product code does not exist, the customer is informed and returned to the Purchase menu.
If a product is sold out, the customer is informed and returned to the Purchase menu.
If a valid product is selected, it is dispensed to the customer.
Dispensing an item prints the item name, cost, and the money remaining. Dispensing also returns a message:
All chip items print "Crunch Crunch, Yum!"
All candy items print "Munch Munch, Yum!"
All drink items print "Glug Glug, Yum!"
All gum items print "Chew Chew, Yum!"
After the product is dispensed, the machine must update its balance accordingly and return the customer to the Purchase menu.
      * */
   }

   public void finishTransaction() {
/*
Selecting "(3) Finish Transaction" allows the customer to complete the transaction and receive any remaining change.
The customer's money is returned using nickels, dimes, and quarters (using the smallest amount of coins possible).
The machine's current balance must be updated to $0 remaining.
      * */
      /*All purchases must be audited to prevent theft from the vending machine:
Each purchase must generate a line in a file called Log.txt.
The audit entry must be in the format:
 01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00*/
   }

   public void exit() {
      System.out.println("Thank you! Have a good day!");
      System.exit(1);
   }

//   public void printBalance(){
//      System.out.println(" Current Money Provided: $"+balance);
//   }
}
