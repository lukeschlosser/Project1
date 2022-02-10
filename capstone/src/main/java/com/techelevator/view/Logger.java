package com.techelevator.view;

import java.io.*;
import java.time.LocalDateTime;

public class Logger {

    LocalDateTime purchasedTime;
    File logFile;
//    int feedMoney;
//    int returnedChange;
    String itemName;
    String slotLocation;

    public Logger() {

        this.logFile = new File("Log.txt");
    }

    public void log(String message) throws FileNotFoundException{
        try(PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))){
        writer.println(LocalDateTime.now() + " " + message);

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

    }



}
