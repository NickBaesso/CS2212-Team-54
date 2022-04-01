public class Coin {
    private String type;
    private float price;

    Coin(String type, float price) {
        this.type = type;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public Boolean equals(Coin coin) {
        return coin.getType().equals(this.type);
    }
}
