package strategy;

import infrastructure.*;

import java.util.ArrayList;

public interface AbstractStrategy {

    public static String getName() {
        return "Strategy-null";
    }

    public TradeResult rule_1();
    public TradeResult rule_2();
    public TradeResult rule_3();
    public TradeResult rule_4();

    public ArrayList<TradeResult> trade();
}
