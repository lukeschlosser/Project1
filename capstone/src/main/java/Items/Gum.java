package Items;

public class Gum extends Item{

    private String name;
    private int price;

    //constructor
    public Gum(String name, int price){
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
