package payments;

public class CashOnDelivery implements PaymentMode{
    private double amount;

    public CashOnDelivery(double amount) {
        this.amount = amount;
    }

    @Override
    public String getDescription() {
        return "Cash On Delivery";
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
