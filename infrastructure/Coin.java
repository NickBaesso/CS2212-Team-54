package infrastructure;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a coin.
 * @author Jiangqi
 */
public class Coin {
    private String name;
    private double price;
    private String symbol; // BTC, USDT, etc.
    private String ID;

    /**
     * Creates a coin with the given parameters
     * this constructor takes a price argument
     * @param name
     * @param symbol
     * @param ID
     * @param price
     */
    public Coin(String name, String symbol, String ID, double price) {
        this.name = name;
        this.price = price;
        this.symbol = symbol;
        this.ID = ID;
    }

    /**
     * Same as above constructor. Does not take a price argument.
     * @param name
     * @param symbol
     * @param ID
     */
    public Coin(String name, String symbol, String ID) {
        this.name = name;
        price = 0.0;
        this.symbol = symbol;
        this.ID = ID;
    }

    /**
     * @return coin price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Update the coin price.
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return the name of the coin (i.e DOGE, BTC, ETH, etc)
     */
    public String getName() {
        return name;
    }

    /**
     * @return coin symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return coin identifier
     */
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
