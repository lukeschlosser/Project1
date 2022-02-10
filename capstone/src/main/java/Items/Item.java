package Items;

public class Item {

    private String name;
    private int price;
    private String type;
    private String slotLocation;

    //constructor
    public Item(){}


    //getters
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }


}
