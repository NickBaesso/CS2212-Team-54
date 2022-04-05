package strategy;

public class StrategyCreatorB extends StrategyCreator {
    @Override
    public StrategyProduct factoryMethod() {
        return new Strategy_B();
    }
}
