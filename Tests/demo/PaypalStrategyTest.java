package demo;

import Classes.IPaymentGateway;
import Classes.PaypalStrategy;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaypalStrategyTest {


    private PaypalStrategy Paypal;
    private IPaymentGateway Payment;
    private Mockery mockingContext;


    @Before
    public void doBeforeEachTestCase()
    {

        mockingContext = new Mockery();
        Paypal = new PaypalStrategy("","");
        Payment= mockingContext.mock(IPaymentGateway.class);
        Paypal.SetPaymentGateway(Payment);
    }

    @Test
    public void pay()
    {
        int amount =1515;
        mockingContext.checking(new Expectations()
        {{
            oneOf(Payment).makePayment(amount);
            will(returnValue(true));
        }});

        boolean T=Paypal.pay(amount);
        mockingContext.assertIsSatisfied();
        assertTrue(T);
    }

    @Test
    public void pay2()
    {

        int amount =90015;
        mockingContext.checking(new Expectations()
        {{
            oneOf(Payment).makePayment(amount);
            will(returnValue(false));
        }});

        boolean T=Paypal.pay(amount);
        mockingContext.assertIsSatisfied();
        assertFalse(T);


    }

    @Test
    public void pay3()
    {

        int amount =3915;
        mockingContext.checking(new Expectations()
        {{
            oneOf(Payment).makePayment(amount);
            will(returnValue(true));
        }});

        boolean T=Paypal.pay(amount);
        mockingContext.assertIsSatisfied();
        assertTrue(T);
    }


}