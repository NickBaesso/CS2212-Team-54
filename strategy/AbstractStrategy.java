package strategy;

import structure.*;

interface AbstractStrategy {
    public Boolean rule_1(Condition c1, Condition c2, Coin target, Quantity quantity);
    public Boolean rule_2(Condition c1, Condition c2, Coin target, Quantity quantity);
    public Boolean rule_3(Condition c1, Condition c2, Coin target, Quantity quantity);
    public Boolean rule_4(Condition c1, Condition c2, Coin target, Quantity quantity);

    public TradeResult doTrade ();

    TradeResult trade(String[] coinList, float[] coinPriceList);
}
