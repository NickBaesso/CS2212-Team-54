public class Quantity {
    private Boolean isCrypto;  // true for crypto, false for CAD
    private float amount;

    Quantity(Boolean type, float amount) {
        isCrypto = type;
        this.amount = amount;
    }

    public float getAmountCrypto(Coin coin) {
        if (isCrypto) return amount;
        else {
            return amount / coin.getPrice();
        }
    }
}
