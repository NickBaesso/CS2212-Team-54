package strategy;
import infrastructure.*;
import utils.AvailableCryptoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * Update required: needs rules!!!!!!!!!!
 * rule 3 and 4 are just copies of 2
 * - Thanks, Jiangqi
 */

public class Strategy_A implements AbstractStrategy {

    String name = "Strategy-A";

    private Strategy_A instance;
    private AvailableCryptoList list;
    private HashMap<String, Coin> hmap;

    private Strategy_A() {
        list = AvailableCryptoList.getInstance();
        hmap = list.getMap();
    }

    public Strategy_A getInstance() {
        if (instance == null)
            instance = new Strategy_A();

        return instance;
    }

    @Override
    public TradeResult rule_1() {

        Condition c1 = new Condition(hmap.get("btc"), 50000, "<=");  // BTC is less than or equal to 50,000
        Condition c2 = new Condition(hmap.get("ada"), 2, ">");  // ADA is more than 2
        Quantity quan = new Quantity(true, 10);  // true for crypto amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Buy",                     // action
                    quan,                             // buy 10 ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

    @Override
    public TradeResult rule_2() {

        Condition c1 = new Condition(hmap.get("eth"), 3500, "<");  // ETH is less than 3500
        Condition c2 = new Condition(hmap.get("ada"), 2, "<=");  // ADA is less than or equal to 2
        Quantity quan = new Quantity(false, 1000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Buy",                     // action
                    quan,                             // buy 10 ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

    @Override
    public TradeResult rule_3() {

        Condition c1 = new Condition(hmap.get("eth"), 3500, "<");  // ETH is less than 3500
        Condition c2 = new Condition(hmap.get("ada"), 2, "<=");  // ADA is less than or equal to 2
        Quantity quan = new Quantity(false, 1000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Buy",                     // action
                    quan,                             // buy 10 ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

    @Override
    public TradeResult rule_4() {

        Condition c1 = new Condition(hmap.get("eth"), 3500, "<");  // ETH is less than 3500
        Condition c2 = new Condition(hmap.get("ada"), 2, "<=");  // ADA is less than or equal to 2
        Quantity quan = new Quantity(false, 1000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-A
                    hmap.get("ada"),                  // coin ADA
                    "Buy",                     // action
                    quan,                             // buy 10 ADA
                    hmap.get("ada").getPrice());      // ADA price
        }
        else return null;
    }

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
