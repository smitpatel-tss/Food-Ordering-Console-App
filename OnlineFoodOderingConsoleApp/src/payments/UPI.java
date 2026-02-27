package payments;

public class UPI implements PaymentMode{
    private double amount;

    public UPI(double amount) {
        this.amount = amount;
    }

    @Override
    public String getDescription() {
        return "UPI";
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
