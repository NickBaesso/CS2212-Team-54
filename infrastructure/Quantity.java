package infrastructure;

public class Quantity {
    private Boolean isCrypto;  // true for crypto, false for CAD
    private double amount;

    public Quantity(Boolean type, double amount) {
        isCrypto = type;
        this.amount = amount;
    }

    public double getAmountCrypto(Coin coin) {
        if (isCrypto) return amount;
        else {
            return amount / coin.getPrice();
        }
    }
}
