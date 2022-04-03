package strategy;
import structure.*;

import utils.AvailableCryptoList;

public class Strategy_A implements AbstractStrategy {

    String name = "Strategy-A";
    private Strategy_A instance;

    private Strategy_A() {}

    public Strategy_A getInstance() {
        if (instance == null)
            instance = new Strategy_A();

        return instance;
    }

    @Override
    public Boolean rule_1(Condition c1, Condition c2, Coin target, Quantity quantity) {
        Condtion c1 =
        return c1.evaluate() && c2.evaluate();
    }

    @Override
    public Boolean rule_2(Condition c1, Condition c2, Coin target, Quantity quantity) {
        return c1.evaluate() && c2.evaluate();
    }

    @Override
    public Boolean rule_3(Condition c1, Condition c2, Coin target, Quantity quantity) {

    }

    @Override
    public Boolean rule_4(Condition c1, Condition c2, Coin target, Quantity quantity) {

    }

    @Override
    public TradeResult trade(String[] coinList, double[] coinPriceList) {
        return null;
    }
}
