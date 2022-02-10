package Items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private String name;
    private int stockAmount = 5;
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

    public List<Item> getItemList(){

        String path = "vendingmachine.csv";
        File itemFile = new File(path);
        try(Scanner input = new Scanner(itemFile)){
            while(input.hasNext()){
                String lineOfText = input.nextLine();
                String[] itemList = lineOfText.split("\\|");

            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
