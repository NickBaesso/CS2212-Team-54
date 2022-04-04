package strategy;
import infrastructure.*;
import utils.AvailableCryptoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Strategy_A implements AbstractStrategy {

    public static String name = "Strategy-A";

    private static Strategy_A instance;
    private AvailableCryptoList list;
    private HashMap<String, Coin> hmap;

    private Strategy_A() {
        list = AvailableCryptoList.getInstance();
        hmap = list.getMap();
    }

    public static String getName() {
        return "Strategy-A";
    }

    public static Strategy_A getInstance() {
        if (instance == null)
            instance = new Strategy_A();

        return instance;
    }

    /**
     * This method determines and compiles the data for the first rule of the Strategy_A trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_1() {

        Condition c1 = new Condition(hmap.get("btc"), 9999999, "<=");  // BTC is less than or equal to 50,000
        Condition c2 = new Condition(hmap.get("ada"), 1, ">");  // ADA is more than 2
        Quantity quan = new Quantity(true, 10);  // true for crypto amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Buy",                            // action
                    quan,                             // buy 10 ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the second rule of the Strategy_A trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_2() {

        Condition c1 = new Condition(hmap.get("eth"), 3500, "<");  // ETH is less than 3500
        Condition c2 = new Condition(hmap.get("ada"), 2, "<=");  // ADA is less than or equal to 2
        Quantity quan = new Quantity(false, 1000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Buy",                            // action
                    quan,                             // buy $1000 of ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the third rule of the Strategy_A trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_3() {

        Condition c1 = new Condition(hmap.get("dot"), 25, ">");  // DOT is greater than 25
        Condition c2 = new Condition(hmap.get("ada"), 2, "<=");  // ADA is less than or equal to 2
        Quantity quan = new Quantity(true, 5);  // true for crypto amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Buy",                            // action
                    quan,                             // buy 5 ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the fourth rule of the Strategy_A trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_4() {

        Condition c1 = new Condition(hmap.get("ada"), 3, ">");  // ADA is greater than 3
        Quantity quan = new Quantity(false, 1000);  // false for CAD amount

        if (c1.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Sell",                           // action
                    quan,                             // sell $1000 worth of ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

    /**
     * This method determines the result after employing all rules for Strategy_A and returns a list of the resulting data.
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

    public static void main(String[] args) {
        Strategy_A strategyA = Strategy_A.getInstance();
        System.out.println(strategyA.trade().get(0).price);
    }
}
