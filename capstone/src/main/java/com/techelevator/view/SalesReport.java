package com.techelevator.view;

public class SalesReport {
    /*Optional - Sales Report
Provide a "Hidden" menu option on the main menu ("4") that writes to a sales report that shows the total sales since the machine was started. The name of the file must include the date and time so each sales report is uniquely named.
An example of the output format is provided below.*/
    private String itemName;
    private int totalSales;


    public SalesReport(String itemName, int totalSales) {
        this.itemName = itemName;
        this.totalSales = totalSales;
    }
    
}
