package com.techelevator;


public class CoinBox {

    private int totalSales;

    public CoinBox() {
    }

//    public int transaction(){
//       // feedMoneyAmount - item
//        return 0;
//    }

    public void giveChange(double amountRecieved) {

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while (amountRecieved >= 0.25) {
            quarters++;
            amountRecieved -= 0.25;
        }

        while (amountRecieved >= 0.10) {
            dimes++;
            amountRecieved -= 0.10;
        }

        while (amountRecieved >= 0.05) {
            nickels++;
            amountRecieved -= 0.05;
        }

        System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");
    }

}
