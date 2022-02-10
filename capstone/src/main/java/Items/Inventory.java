package Items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private String name;
    private int stockAmount;
    private String slotLocation;

    //constructor
    public Inventory(){}

    //getters
    public String getName() {
        return name;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public List<String[]> getItemList(){

        String path = "vendingmachine.csv";
        File itemFile = new File(path);
        String [] itemList = new String[]{};
        List<String[]> stockList = new ArrayList();
        try(Scanner input = new Scanner(itemFile)){
            while(input.hasNext()){
                String lineOfText = input.nextLine();
                itemList = lineOfText.split("\\|");
                stockList.add(itemList);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return stockList;
    }

}
