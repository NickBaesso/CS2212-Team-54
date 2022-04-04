package strategy;

import infrastructure.Coin;

/**
 * Evaluates the relationship between 2 coins for the strategy class
 * @author Jinagqi
 */
public class Condition {
    private Coin target; // Coin the relation will be affecting
    private double price; // Price provided
    private String relation; // Relation type between 2 coins (i.e. <, <=, ==, etc..)

    Condition(Coin target, double price, String relation) {
        this.target = target;
        this.price = price;
        this.relation = relation;
    }

    /**
     * Does the actual operational evaluation of the given parameters.
     * @return true or false depending on the nature of the relationship
     */
    public boolean evaluate() {
        switch (relation) {
            case "<":
                return target.getPrice() < price;
            case "<=":
                return target.getPrice() <= price;
            case "=":
                return target.getPrice() == price;
            case ">=":
                return target.getPrice() >= price;
            case ">":
                return target.getPrice() > price;
        }

        return false;
    }
}
