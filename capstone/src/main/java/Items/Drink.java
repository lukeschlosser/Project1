package Items;

public class Drink extends Item {

    private String name;
    private int price;

    //constructor
    public Drink(String name, int price){
        this.name = name;
        this.price = price;
    }

    //getters

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
