package strategy;

public class StrategyCreatorA extends StrategyCreator {
    @Override
    public StrategyProduct factoryMethod() {
        return new Strategy_A();
    }
}
