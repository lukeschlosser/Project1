package Items;

import java.util.List;

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
        return null;
    }

}
