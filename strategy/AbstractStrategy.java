package strategy;

import infrastructure.*;

import java.util.ArrayList;

public interface AbstractStrategy {
    public TradeResult rule_1();
    public TradeResult rule_2();
    public TradeResult rule_3();
    public TradeResult rule_4();

    public ArrayList<TradeResult> trade();
}
