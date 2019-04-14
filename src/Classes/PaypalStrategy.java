package Classes;

public class PaypalStrategy  implements IPaymentStrategy {

    private String emailId;
    private String password;

    private IPaymentGateway paymentGateway;

    public PaypalStrategy(String email, String pwd)
    {
        this.emailId = email;
        this.password = pwd;
    }

    public void SetPaymentGateway(IPaymentGateway paymentGateway)
    {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public boolean pay(int amount)
    {
        if (paymentGateway.makePayment(amount))
        {
            System.out.println(amount + " paid using Paypal.");
            return true;
        }
        return false;
    }

}
