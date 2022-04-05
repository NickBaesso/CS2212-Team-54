package strategy;

public class StrategyCreatorD extends StrategyCreator {
    @Override
    public StrategyProduct factoryMethod() {
        return new Strategy_D();
    }
}
