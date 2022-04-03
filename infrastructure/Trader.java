package infrastructure;
/*
 * equivalent to broker
 * by Jiangqi
 */

import strategy.AbstractStrategy;

import java.util.ArrayList;
import java.util.List;

public class Trader {
    String name;
    List<Coin> interestedCoinList = new ArrayList<Coin>();
    List<AbstractStrategy> strategyList = new ArrayList<AbstractStrategy>();

    public void addInterestingCoin(Coin coin) {
        interestedCoinList.add(coin);
    }

    public void addStrategy(AbstractStrategy strategy) {
        strategyList.add(strategy);
    }

    public void notifyUpdatedCoinPrice(Coin coin) {  // as required
        coin.setPrice(coin.getPrice());
    }
}
