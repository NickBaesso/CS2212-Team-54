package strategy;

/**
 * 1 of four manufacturers for the Strategy factory
 * @author Jiangqi
 */
public class StrategyManufacturer_A extends StrategyFactory {
    @Override
    public Strategy_A getStrategy() { return Strategy_A.getInstance(); }
}
