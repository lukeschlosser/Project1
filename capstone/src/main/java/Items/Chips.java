package Items;

public class Chips extends Item{

    private String name;
    private int price;

    //constructor
    public Chips(String name, int price){
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
