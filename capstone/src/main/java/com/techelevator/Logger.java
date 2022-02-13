package com.techelevator;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private File logFile;

    public Logger() {
        this.logFile = new File("Log.txt");
    }

    public void log(String message) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
            writer.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a")) + " " + message);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
