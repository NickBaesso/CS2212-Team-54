package utils;

import infrastructure.*;
import strategy.AbstractStrategy;
import strategy.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Trade {
    private ArrayList<Trader> traderList;
    private AvailableCryptoList list;
    private HashMap<String, Coin> hmap;

    public Trade(ArrayList<Trader> traderList) {
        this.traderList = traderList;
    }


    // Output like this: {{"Trader-3", "Strategy-C", "HNT", "Buy", "1000", "2.59","20-January-2022"},}
    public String[][] doTrade() {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        updateInterestedCoins();

        for (Trader trader : traderList) {

            AbstractStrategy strategy;

            if (trader.getStrategy().getClass().getName().equals("strategy.Strategy_A")) {
                strategy = Strategy_A.getInstance();
            }
            else if (trader.getStrategy().getClass().getName().equals("strategy.Strategy_B")) {
                strategy = Strategy_B.getInstance();
            }
            else if (trader.getStrategy().getClass().getName().equals("strategy.Strategy_C")) {
                strategy = Strategy_C.getInstance();
            }
            else {
                strategy = Strategy_D.getInstance();
            }

            for (TradeResult t : strategy.trade()) {
                ArrayList<String> row = new ArrayList<String>();

                t.trader = trader;
                row.add(trader.getName());
                row.add(t.strategy);
                row.add(t.coin.getSymbol().toUpperCase());
                row.add(t.action);
                row.add(String.valueOf(t.quantity.getAmountCrypto(t.coin)));
                row.add(String.valueOf(t.price));
                row.add(Date.getResultDate());

                result.add(row);
            }
        }

        System.out.println(Arrays.deepToString(result.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new)));
        return result.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
    }

    public ArrayList<TradeResult> getResultList() {
        ArrayList<TradeResult> resultList = new ArrayList<TradeResult>();

        for (Trader trader : traderList) {

            AbstractStrategy strategy;

            if (trader.getStrategy().getClass().getName().equals("strategy.Strategy_A")) {
                strategy = Strategy_A.getInstance();
            }
            else if (trader.getStrategy().getClass().getName().equals("strategy.Strategy_B")) {
                strategy = Strategy_B.getInstance();
            }
            else if (trader.getStrategy().getClass().getName().equals("strategy.Strategy_C")) {
                strategy = Strategy_C.getInstance();
            }
            else {
                strategy = Strategy_D.getInstance();
            }

            for (TradeResult t : strategy.trade()) {
                t.trader = trader;

                resultList.add(t);
            }
        }

        return resultList;
    }

    private void updateInterestedCoins() {

        list = AvailableCryptoList.getInstance();
        hmap = list.getMap();  // this updates all coin prices

        for (Trader t : traderList) {
            for (Coin c : t.getInterestCoinList()) {
                t.notifyUpdatedCoinPrice(hmap.get(c.getSymbol()));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Coin> clist = new ArrayList<Coin>();
        String tname = "Trader-1";
        AbstractStrategy strategy = Strategy_A.getInstance();
        Trader trader = new Trader(tname, clist, strategy);
        ArrayList<Trader> traderList = new ArrayList<Trader>();
        traderList.add(trader);
        Trade t = new Trade(traderList);

        System.out.println(Arrays.deepToString(t.doTrade()));
    }
}
