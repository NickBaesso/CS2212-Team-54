package infrastructure;

import strategy.AbstractStrategy;

import java.util.ArrayList;

/**
 * equivalent to broker
 * by Jiangqi
 */
public class Trader {
    private String name;
    private ArrayList<Coin> interestedCoinList;
    private AbstractStrategy strategy;

    public Trader(String name, ArrayList<Coin> clist, AbstractStrategy slist) {
        this.name = name;
        interestedCoinList = clist;
        strategy = slist;
    }

    /**
     * @return strategy
     */
    public AbstractStrategy getStrategy() {
        return strategy;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return List of coins user is interested in.
     */
    public ArrayList<Coin> getInterestCoinList() {
        return interestedCoinList;
    }

    /**
     * Inserts a new coin into the list of the coins the broker is interested in.
     * @param coin
     */
    public void addInterestingCoin(Coin coin) {
        interestedCoinList.add(coin);
    }

    /**
     * Notifies the trader of a new coin and updates
     * the coin price.
     * @param coin
     */
    public void notifyUpdatedCoinPrice(Coin coin) {  // as required
        coin.setPrice(coin.getPrice());
    }
}
