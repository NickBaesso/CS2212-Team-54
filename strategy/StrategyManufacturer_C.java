package strategy;

public class StrategyManufacturer_C extends StrategyFactory {

    @Override
    public Strategy_C getStrategy() {
        return Strategy_C.getInstance();
    }
}
