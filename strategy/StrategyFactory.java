package strategy;

/**
 * Part of the Factory design pattern.
 * @author Jiangqi
 */
public abstract class StrategyFactory {
    /** @return the strategy used.
     */
    public abstract AbstractStrategy getStrategy();
}
