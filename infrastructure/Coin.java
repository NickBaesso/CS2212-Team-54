package infrastructure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Coin {
    private String name;
    private double price;
    private String symbol; // BTC, USDT, etc.
    private String ID;

    public Coin(String name, String symbol, String ID, double price) {
        this.name = name;
        this.price = price;
        this.symbol = symbol;
        this.ID = ID;
    }

    public Coin(String name, String symbol, String ID) {
        this.name = name;
        this.price = 0.0;
        this.symbol = symbol;
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getID() {
        return ID;
    }

    public Boolean equals(Coin coin) {
        return (coin.getName().equals(name) || coin.getSymbol().equals(symbol));
    }

    public Boolean equals(String name) {
        return (this.name.equals(name) || this.symbol.equals(name));
    }

    public static void main(String[] args) {
        Coin btc = new Coin("Bitcoin", "BTC", "bitcoin", 1.1);
        Coin anotherBTC = new Coin("Bitcoin", "BTC","bitcoin", 1.6);
        System.out.println(new SimpleDateFormat("dd-MMMM-yyyy").format(new Date()));
    }
}
