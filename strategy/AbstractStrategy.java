package strategy;

import infrastructure.*;

import java.util.ArrayList;

/**
 * This interface provides the rule and trade methods
 * for the strategy classes used in the strategies.
 *
 * @author Jiangqi
 */
public interface AbstractStrategy {

    public static String getName() {
        return "Strategy-null";
    }

    TradeResult rule_1();
    TradeResult rule_2();
    TradeResult rule_3();
    TradeResult rule_4();

    ArrayList<TradeResult> trade();
}
