package structure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used to define trade brokers.
 * Not finished. Will add rest of commments and code later.
 * @author Jay
 */
public class Broker {
    private String name;
    private String coin;
    private String strategy;
    private ArrayList<String> cryptoCoins;

    public Broker (String name, String strategy, String coins) {
        this.name = name;
        this.strategy = strategy;
        cryptoCoins = new ArrayList<String>();
        cryptoCoins.addAll(Arrays.asList(coins.split(",")));
    }

    public void setBrokerName (String name) { this.name = name; }

    public String getBrokerName () { return name; }

    public void addCoin (String coin) { cryptoCoins.add(coin); }

    public void removeCoin (String coin) { cryptoCoins.remove(coin); }

    public void setStrategy (String strategy) { this.strategy = strategy; }

    public String getStrategy () { return strategy; }
}
