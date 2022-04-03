package structure;

import structure.Broker;
import structure.Coin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TradeResult {

    // this is just a data structure, no need to hide the data; change it all you want
    Broker trader;
    String strategy;
    Coin coin;
    String action;
    int quantity;
    float price;
    String date;

    TradeResult(
            Broker dw, String strategy, Coin coin, String action,
            int quantity, float price, String date) {
        trader = dw;
        this.strategy = strategy;
        this.coin = coin;
        this.action = action;
        this.quantity = quantity;
        this.price = price;
        this.date  = new SimpleDateFormat("dd-MM-yyyy").format(new Date());;
    }


}
