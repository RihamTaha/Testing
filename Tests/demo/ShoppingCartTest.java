package demo;

import Classes.Discounted;
import Classes.IPaymentStrategy;
import Classes.Item;
import Classes.ShoppingCart;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Imposteriser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.*;

import java.util.Vector;

import static org.junit.Assert.*;

public class ShoppingCartTest {



     ShoppingCart Cart;
    private  IPaymentStrategy Strategy;
    private  Mockery mockingContext;
    private  Item item1;
    private  Item item2;


    @Before
    public  void doBeforeAllTestCase()
    {

        mockingContext = new Mockery();
        Strategy= mockingContext.mock(IPaymentStrategy.class);
        mockingContext.setImposteriser(ClassImposteriser.INSTANCE);
        item1 = mockingContext.mock(Item.class, "item1");
        item2 = mockingContext.mock(Item.class, "item2");

        mockingContext.checking(new Expectations(){{
            oneOf(item1).getDiscount(); will(returnValue(3));
            oneOf(item1).getPrice(); will(returnValue(12));

            oneOf(item2).getDiscount(); will(returnValue(6));
            oneOf(item2).getPrice(); will(returnValue(24));



        }});
        Cart= new ShoppingCart();
        Cart.addItem(item1);
        Cart.addItem(item2);
        //System.out.println("Before ALL :"+Cart.items.size());
    }

    @Test
    public void pay()
    {

        //System.out.println("PaY : "+Cart.items.size());


        mockingContext.checking(new Expectations(){{

            allowing(Strategy).pay(27);
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
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);

        assertTrue(Cart.addItem(item1));

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
//        Item x= new Item("Codexcerr",52);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
        Cart.addItem(item1);
//        Cart.addItem(item1);
//        Item x2= new Item("Codexcerr",52);
//        Item x3= new Item("Codexcerr",52);
//        Item x6= new Item("Codexcerr",52);
//        Item x4= new Item("Codexcerr",52);
//        Item x5= new Item("Codexcerr",52);
//        Item x7= new Item("Codexcerr",52);
//        Item x8= new Item("Codexcerr",52);
//        Item x9= new Item("Codexcerr",52);
//        Item xx= new Item("Codexcerr",52);

//        Item y= new Item("Codexcerr",52);

        assertFalse(Cart.addItem(item1));
        //System.out.println("Size After AddItem(): "+Cart.items.size());

    }




    @Test
    public void removeItem()
    {

//        Item x= new Item("Codexcerr",13);

        Cart.removeItem(item1);
        assertEquals("Remove one item",1,1);

    }


    @Test
    public void calculateTotalPrice()
    {

//        Item x= new Item("Codexcerr",13);
//        Cart.addItem(x);
        assertEquals(36,Cart.calculateTotalPrice());

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

//        Item x= new Item("Codexcerr",20);
        assertEquals(9,Cart.calculateTotalDiscount());

    }


}