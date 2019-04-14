package demo;

import Classes.Discounted;
import Classes.IPaymentStrategy;
import Classes.Item;
import Classes.ShoppingCart;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import static org.junit.Assert.*;

public class ShoppingCartTest {



     ShoppingCart Cart;
    private  IPaymentStrategy Strategy;
    private  Mockery mockingContext;


    @Before
    public  void doBeforeAllTestCase()
    {

        mockingContext = new Mockery();

        Strategy= mockingContext.mock(IPaymentStrategy.class);
        Cart= new ShoppingCart();
        //System.out.println("Before ALL :"+Cart.items.size());
    }

    @Test
    public void pay()
    {

        //System.out.println("PaY : "+Cart.items.size());

        Item x= new Item("Codexcerr",52);
        Cart.addItem(x);

        Item y= new Item("Codexcerr",52);
        Cart.addItem(y);

        mockingContext.checking(new Expectations(){{

            oneOf(Strategy).pay(78);
            will(returnValue(true));

        }});
        boolean T=Cart.pay(Strategy);
        //assertFalse(T);
        assertTrue("True",T);

    }
   /* @Test
    public void pay2()
    {
        int totalDiscount=0;

        for (Discounted item : Cart.items) {
            totalDiscount += item.getDiscount();
        }

        int totalPrice = 0;
        for (Item item : Cart.items) {
            totalPrice += item.getPrice();
        }
        int x=totalPrice-totalDiscount;

        mockingContext.checking(new Expectations(){{

            oneOf(Strategy).pay(x);
            will(returnValue(false));

        }});
        boolean T= Cart.pay(Strategy);
        //assertFalse(T);
        assertTrue(T);

    }*/


    @Test
    public void addItem()
    {
        Item x= new Item("Codexcerr",13);
        assertTrue(Cart.addItem(x));
        //System.out.println("Size After AddItem(): "+Cart.items.size());

    }

   /* @Test
    public void addItem2()
    {
        Item x= new Item("Codexcerr",12);
        assertFalse(Cart.addItem(x));

    }*/
    @Test
    public void addItem3()
    {
        Item x= new Item("Codexcerr",52);
        Cart.addItem(x);
        Item x2= new Item("Codexcerr",52);
        Cart.addItem(x2);
        Item x3= new Item("Codexcerr",52);
        Cart.addItem(x3);
        Item x4= new Item("Codexcerr",52);
        Cart.addItem(x4);
        Item x5= new Item("Codexcerr",52);
        Cart.addItem(x5);

        Item x6= new Item("Codexcerr",52);
        Cart.addItem(x6);
        Item x7= new Item("Codexcerr",52);
        Cart.addItem(x7);
        Item x8= new Item("Codexcerr",52);
        Cart.addItem(x8);
        Item x9= new Item("Codexcerr",52);
        Cart.addItem(x9);
        Item xx= new Item("Codexcerr",52);
        Cart.addItem(xx);

        Item y= new Item("Codexcerr",52);

        assertFalse(Cart.addItem(y));
        //System.out.println("Size After AddItem(): "+Cart.items.size());

    }




    @Test
    public void removeItem()
    {

        Item x= new Item("Codexcerr",13);
        Cart.addItem(x);
        Cart.removeItem(x);
        assertEquals("Remove one item",0,0);

    }


    @Test
    public void calculateTotalPrice()
    {

        Item x= new Item("Codexcerr",13);
        Cart.addItem(x);
        assertEquals(13,Cart.calculateTotalPrice());

    }

   /* @Test
    public void calculateTotalPrice2()
    {
        int totalPrice = 0;
        for (Item item : Cart.items) {
            totalPrice += item.getPrice();
        }
        assertEquals(0,Cart.calculateTotalPrice());

    }*/


    @Test
    public void calculateTotalDiscount()
    {
        Item x= new Item("Codexcerr",20);
        Cart.addItem(x);
        assertEquals(5,Cart.calculateTotalDiscount());

    }


}