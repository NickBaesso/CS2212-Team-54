package strategy;

public class StrategyManufacturer_A extends StrategyFactory {

    @Override
    public Strategy_A getStrategy() {
        return Strategy_A.getInstance();
    }
}
