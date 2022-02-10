package Items;

public class Candy extends Item{

    private String name;
    private int price;
    private int quantity;

    //constructor
    public Candy(String name, int price){
        this.name = name;
        this.price = price;
        this.quantity = 5;
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
