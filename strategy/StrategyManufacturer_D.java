package strategy;

public class StrategyManufacturer_D extends StrategyFactory {

    @Override
    public Strategy_D getStrategy() {
        return Strategy_D.getInstance();
    }

    // test only
    public static void main(String[] args) {
        System.out.println(new StrategyManufacturer_D().getStrategy().getName());
    }
}
