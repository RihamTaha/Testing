package demo;

import Classes.CreditCardStrategy;
import Classes.IPaymentGateway;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CreditCardStrategyTest {

   private CreditCardStrategy Credit;
   private IPaymentGateway Payment;
   //private IPaymentStrategy Strategy;
   private Mockery mockingContext;

    @Before
    public void doBeforeEachTestCase()
    {
        /*mockingContext=new Mockery();
        //Strategy=mockingContext.mock(IPaymentStrategy.class);
        Payment=mockingContext.mock(IPaymentGateway.class);

        System.out.println(Payment + "\t fdfdf ");
        Credit.SetPaymentGateway(Payment);*/

        mockingContext = new Mockery();
        Credit = new CreditCardStrategy("","","","");
        Payment= mockingContext.mock(IPaymentGateway.class);
        Credit.SetPaymentGateway(Payment);

    }
    @Test
    public void pay()
    {
        //System.out.println(Payment + "\t RRRR ");

        int amount =6;
        mockingContext.checking(new Expectations()
        {{
            oneOf(Payment).makePayment(amount);
            will(returnValue(true));
        }});

        boolean T=Credit.pay(amount);
        mockingContext.assertIsSatisfied();
        //Assert.assertEquals(true,T);
        //assertFalse(T);
        assertTrue(T);

    }
    @Test
    public void pay2()
    {




        int amount =6;
        mockingContext.checking(new Expectations()
        {{
            oneOf(Payment).makePayment(amount);
            will(returnValue(false));
        }});

        boolean T=Credit.pay(amount);
        mockingContext.assertIsSatisfied();
        //Assert.assertEquals(true,T);
        assertFalse(T);
        //assertTrue(T);




    }


    /*@Test
    public void pay3()
    {


        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps=new PrintStream(os);
        System.setOut(ps);


        int amount =6;
        mockingContext.checking(new Expectations()
        {{
            oneOf(Payment).makePayment(amount);
            will(returnValue(false));
        }});

        boolean T=Credit.pay(amount);
        mockingContext.assertIsSatisfied();
        //Assert.assertEquals(true,T);
        assertFalse(T);
        //assertTrue(T);

    }*/


}