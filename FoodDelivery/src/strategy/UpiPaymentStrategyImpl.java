package strategy;

public class UpiPaymentStrategyImpl implements PaymentStrategy{
    private String mobile;

    public UpiPaymentStrategyImpl(String mob) {
        this.mobile = mob;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI (" + mobile + ")");
    }
}
