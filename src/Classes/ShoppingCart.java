package Classes;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{

    List<Item> items;
    final int CartCapacity = 10;

    public ShoppingCart()
    {
        this.items = new ArrayList<>();
    }

    public boolean addItem(Item item)
    {
        if (items.size() == CartCapacity)
        {
            System.out.println("your cart is already full!");
            return false;
        }
        this.items.add(item);
        return true;
    }

    public void removeItem(Item item) {

        this.items.remove(item);
    }

    public int calculateTotalPrice()
    {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int calculateTotalDiscount()
    {
        int totalDiscount = 0;
        for (Discounted item : items) {
            totalDiscount += item.getDiscount();
        }
        return totalDiscount;
    }

    public boolean pay(IPaymentStrategy paymentMethod)
    {
        int totalPrice = calculateTotalPrice();
        int totalDiscount = calculateTotalDiscount();
        return paymentMethod.pay(totalPrice - totalDiscount);
    }
}
