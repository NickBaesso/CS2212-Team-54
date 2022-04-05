package strategy;
import infrastructure.*;
import utils.AvailableCryptoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 2nd of four strategies for the program.
 * @author Nick
 */
public class Strategy_B implements AbstractStrategy {
    private static final String name = "Strategy-B";

    private static Strategy_B instance;
    private AvailableCryptoList list;
    private HashMap<String, Coin> hmap;

    private Strategy_B() {
        list = AvailableCryptoList.getInstance();
        hmap = list.getMap();
    }

    public static Strategy_B getInstance() {
        if (instance == null)
            instance = new Strategy_B();

        return instance;
    }

    public static String getName() {
        return name;
    }

    /**
     * This method determines and compiles the data for the first rule of the Strategy_B trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_1() {

//         Condition c1 = new Condition(hmap.get("btc"), 40000, "<=");  // BTC is less than or equal to 40,000
//         Condition c2 = new Condition(hmap.get("bnb"), 600, ">");  // BNB is more than 600
        Condition c1 = new Condition(hmap.get("btc"), 60000, "<=");  // BTC is less than or equal to 40,000
        Condition c2 = new Condition(hmap.get("bnb"), 400, ">");  // BNB is more than 600
        
        Quantity quan = new Quantity(true, 5);  // true for crypto amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-B
                    hmap.get("btc"),                  // coin BTC
                    "Buy",                            // action
                    quan,                             // buy 5 BTC
                    hmap.get("btc").getPrice());      // BTC price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the second rule of the Strategy_B trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_2() {

//         Condition c1 = new Condition(hmap.get("btc"), 55000, "<=");  // BTC is less than or equal to 55,000
//         Condition c2 = new Condition(hmap.get("ada"), 2, "<=");  // ADA is less than or equal to 2
        Condition c1 = new Condition(hmap.get("btc"), 60000, "<=");  // BTC is less than or equal to 55,000
        Condition c2 = new Condition(hmap.get("ada"), 3, "<=");  // ADA is less than or equal to 2
        
        Quantity quan = new Quantity(false, 10000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-B
                    hmap.get("btc"),                  // coin BTC
                    "Buy",                            // action
                    quan,                             // buy $10000 worth of BTC
                    hmap.get("btc").getPrice());      // BTC price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the third rule of the Strategy_B trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_3() {

//         Condition c1 = new Condition(hmap.get("btc"), 60000, "<=");  // ETH is less than or equal to 60000
//         Condition c2 = new Condition(hmap.get("eth"), 4000, ">");  // ETH is more than 4000
        Condition c1 = new Condition(hmap.get("btc"), 60000, "<=");  // ETH is less than or equal to 60000
        Condition c2 = new Condition(hmap.get("eth"), 2000, ">");  // ETH is more than 4000
        
        Quantity quan = new Quantity(false, 10000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-B
                    hmap.get("btc"),                  // coin BTC
                    "Buy",                            // action
                    quan,                             // buy $10000 worth of BTC
                    hmap.get("btc").getPrice());      // BTC price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the fourth rule of the Strategy_B trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_4() {

//         Condition c1 = new Condition(hmap.get("btc"), 80000, ">");  // ETH is more than 80000
        Condition c1 = new Condition(hmap.get("btc"), 80000, ">");  // ETH is more than 80000
        
        Quantity quan = new Quantity(true, 10);  // true for crypto amount

        if (c1.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-B
                    hmap.get("btc"),                  // coin BTC
                    "Sell",                           // action
                    quan,                             // sell 10 BTC
                    hmap.get("btc").getPrice());      // BTC price
        }
        else return null;
    }

    /**
     * This method determines the result after employing all rules for Strategy_B and returns a list of the resulting data.
     * 
     * @return A list of all the results after all the rules are used.
     */
    @Override
    public ArrayList<TradeResult> trade() {
        ArrayList<TradeResult> results = new ArrayList<TradeResult>();
        results.add(rule_1());
        results.add(rule_2());
        results.add(rule_3());
        results.add(rule_4());

        results.removeAll(Collections.singleton(null));  // remove all unsuccessful trades
        return results;
    }
}
