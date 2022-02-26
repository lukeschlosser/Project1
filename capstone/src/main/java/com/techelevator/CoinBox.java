package com.techelevator;


import java.math.BigDecimal;

public class CoinBox {
    // update the totalSales after user's selection
    private BigDecimal totalSales;
    private static CoinBox cb;

    private  CoinBox() {}

    public static CoinBox getInstance()
    {
        if (cb==null)
            cb = new CoinBox();
        return cb;
    }
//    public int transaction(){
//       // feedMoneyAmount - item
//        return 0;
//    }

    public void giveChange(BigDecimal change) {

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        while (change.compareTo(new BigDecimal("0.25")) >=0 ) {
            quarters++;
            change= change.subtract(new BigDecimal("0.25"));
        }

        while (change.compareTo(new BigDecimal("0.10")) >=0) {
            dimes++;
            change= change.subtract(new BigDecimal("0.10"));
        }

        while (change.compareTo(new BigDecimal("0.05")) >=0) {
            nickels++;
            change= change.subtract(new BigDecimal("0.05"));
        }

        System.out.println("Your change is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");
    }
}
