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

    /**
     * @return the name of the particular strategy.
     */
    static String getName() {
        return "Strategy-null";
    }

    /**
     * These classes represent the different rules for the
     * various trading strategies.
     * @return A trade result
     */
    TradeResult rule_1();
    TradeResult rule_2();
    TradeResult rule_3();
    TradeResult rule_4();

    /**
     * The trade method.
     * @return an array of the different trades that occured.
     */
    ArrayList<TradeResult> trade();
}
