package strategy;
import infrastructure.*;
import utils.AvailableCryptoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * last of 4 strategies for computing trade data
 * @author Nick
 */
public class Strategy_D extends StrategyManufacturer_D implements AbstractStrategy {
    private static final String name = "Strategy-D";

    private static Strategy_D instance;
    private AvailableCryptoList list;
    private HashMap<String, Coin> hmap;

    private Strategy_D() {
        list = AvailableCryptoList.getInstance();
        hmap = list.getMap();
    }

    public static Strategy_D getInstance() {
        if (instance == null)
            instance = new Strategy_D();

        return instance;
    }

    public static String getName() {
        return name;
    }

    /**
     * This method determines and compiles the data for the first rule of the Strategy_D trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_1() {

        Condition c1 = new Condition(hmap.get("bnb"), 900, "<=");  // BNB is less than or equal to 900
        Condition c2 = new Condition(hmap.get("luna"), 50, ">");  // LUNA is more than 50
        
        Quantity quan = new Quantity(true, 2);  // true for crypto amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-D
                    hmap.get("bnb"),                  // coin BNB
                    "Buy",                            // action
                    quan,                             // buy 2 BNB
                    hmap.get("bnb").getPrice());      // BNB price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the second rule of the Strategy_D trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_2() {

        Condition c1 = new Condition(hmap.get("bnb"), 750, "<=");  // BNB is less than or equal to 750
        Condition c2 = new Condition(hmap.get("avax"), 25, ">");  // AVAX is more than 25
        
        Quantity quan = new Quantity(false, 3000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-D
                    hmap.get("bnb"),                  // coin BNB
                    "Buy",                            // action
                    quan,                             // buy $3000 worth of BNB
                    hmap.get("bnb").getPrice());      // BNB price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the third rule of the Strategy_D trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_3() {

        Condition c1 = new Condition(hmap.get("bnb"), 700, "<=");  // BNB is less than or equal to 700
        Condition c2 = new Condition(hmap.get("eth"), 1500, ">=");  // ETH is more than or equal to 1500
        Condition c3 = new Condition(hmap.get("ada"), 1, ">");  // ADA is more than 1
        
        Quantity quan = new Quantity(false, 5000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate() && c3.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-D
                    hmap.get("bnb"),                  // coin BNB
                    "Buy",                            // action
                    quan,                             // buy $5000 worth of BNB
                    hmap.get("bnb").getPrice());      // BNB price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the fourth rule of the Strategy_D trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_4() {
        Condition c1 = new Condition(hmap.get("bnb"), 600, ">");  // BNB is more than 600
        
        Quantity quan = new Quantity(false, 200);  // false for CAD amount

        if (c1.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-D
                    hmap.get("bnb"),                  // coin BNB
                    "Sell",                           // action
                    quan,                             // sell $200 worth of BNB
                    hmap.get("bnb").getPrice());      // BNB price
        }
        else return null;
    }

    /**
     * This method determines the result after employing all rules for Strategy_D and returns a list of the resulting data.
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
