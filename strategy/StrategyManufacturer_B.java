package strategy;

public class StrategyManufacturer_B extends StrategyFactory {

    @Override
    public Strategy_B getStrategy() {
        return Strategy_B.getInstance();
    }
}
