package Classes;

public class CreditCardStrategy implements IPaymentStrategy {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    private IPaymentGateway paymentGateway;

    public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
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
            System.out.println(amount + " paid with credit/debit card");
            return true;
        }
        return false;
    }
}
