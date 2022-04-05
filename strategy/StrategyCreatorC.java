package strategy;

public class StrategyCreatorC extends StrategyCreator {
    @Override
    public StrategyProduct factoryMethod() {
        return new Strategy_C();
    }
}
