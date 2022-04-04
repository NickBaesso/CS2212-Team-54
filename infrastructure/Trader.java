package infrastructure;
/*
 * equivalent to broker
 * by Jiangqi
 */

import strategy.AbstractStrategy;
import strategy.Strategy_A;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    String name;
    ArrayList<Coin> interestedCoinList;
    AbstractStrategy strategy;

    public Trader(String name, ArrayList<Coin> clist, AbstractStrategy slist) {
        this.name = name;
        interestedCoinList = clist;
        strategy = slist;
    }

    public AbstractStrategy getStrategy() {
        return strategy;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Coin> getInterestCoinList() {
        return interestedCoinList;
    }

    public void addInterestingCoin(Coin coin) {
        interestedCoinList.add(coin);
    }

    public void notifyUpdatedCoinPrice(Coin coin) {  // as required
        coin.setPrice(coin.getPrice());
    }
}
