package Classes;

public class Item implements Discounted {

    private String upcCode;
    private int price;

    public Item(String upc, int cost) {
        this.upcCode = upc;
        this.price = cost;
    }

    public String getUpcCode()
    {
        return upcCode;
    }

    public int getPrice()
    {

        return price;
    }

    @Override
    public int getDiscount()

    {
        return price / 4;
    }

}