package infrastructure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeResult {

    // this is just a data structure, no need to hide the data
    public String strategy;
    public Coin coin;
    public String action;
    public Quantity quantity;
    public double price;
    public String date;
    public Trader trader;

    public TradeResult(String strategy, Coin coin, String action, Quantity quantity, double price) {
        this.strategy = strategy;
        this.coin = coin;
        this.action = action;
        this.quantity = quantity;
        this.price = price;
        this.date  = new SimpleDateFormat("dd-MM-yyyy").format(new Date());;
    }

}
