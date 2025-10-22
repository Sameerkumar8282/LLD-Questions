package strategy;

public class CreditCarPaymentStrategyImpl implements PaymentStrategy {
    private String cardNumber;

    public CreditCarPaymentStrategyImpl(String card) {
        this.cardNumber = card;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card (" + cardNumber + ")");
    }
}
