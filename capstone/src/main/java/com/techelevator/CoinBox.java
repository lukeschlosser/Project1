package com.techelevator;


public class CoinBox {
    // update the totalSales after user's selection
    private int totalSales;

    public CoinBox() {
    }

//    public int transaction(){
//       // feedMoneyAmount - item
//        return 0;
//    }

    public void giveChange(double change) {

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while (change >= 0.25) {
            quarters++;
            change -= 0.25;
        }

        while (change >= 0.10) {
            dimes++;
            change -= 0.10;
        }

        while (change >= 0.05) {
            nickels++;
            change -= 0.05;
        }

        System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");
    }

}
