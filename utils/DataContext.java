package utils;

public class DataContext {
    private FetcherStrategy strategy;

    public DataContext(FetcherStrategy strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(FetcherStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.getDataForCrypto(this, "", "");
        strategy.getPriceForCoin(this, "", "");
    }

}
