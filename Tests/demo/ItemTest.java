package demo;

import Classes.Item;
import org.junit.Assert;
import org.junit.Test;


public class ItemTest {

    @Test
    public void getUpcCode()
    {
        Item x= new Item("Codexcerr",56);
        Assert.assertEquals("Codexcerr",x.getUpcCode());
    }

   /* @Test
    public void getUpcCode2()
    {
        Item x= new Item("Codexcerr",1080);
        assertEquals("xcerrCode",x.getUpcCode());
    }
    @Test
    public void getUpcCode3()
    {
        Item x= new Item(" ",789);
        assertEquals("Codexcerr",x.getUpcCode());
    }*/



    @Test
    public void getPrice()
    {
        Item x= new Item("Codexcerr",56);
        Assert.assertEquals(56,x.getPrice());

    }
   /* @Test
    public void getPrice2()
    {
        Item x= new Item("Codexcerr",1080);
        assertEquals(56,x.getPrice());

    }
    @Test
    public void getPrice3()
    {
        Item x= new Item("Codexcerr",789);
        assertEquals(-7890,x.getPrice());

    }*/

    @Test
    public void getDiscount()
    {
        Item x= new Item("Codexcerr",56);
        Assert.assertEquals(56/4 , x.getDiscount());
    }

    /*@Test
    public void getDiscount2()
    {
        Item x= new Item("Codexcerr",13);
        assertEquals(4 , x.getDiscount());
    }

    @Test
    public void getDiscount3()
    {
        Item x= new Item("Codexcerr",13);
        assertEquals(-4, x.getDiscount());
    }
    @Test
    public void getDiscount4()
    {
        Item x= new Item("Codexcerr",0);
        assertEquals(4, x.getDiscount());
    }*/

    @Test
    public void getDiscount5()
    {
        Item x= new Item("Codexcerr",0);
        Assert.assertEquals(0, x.getDiscount());
    }


}