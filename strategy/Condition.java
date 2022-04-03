package strategy;

import structure.Coin;

public class Condition {
    Coin target;
    double price;
    String relation;

    Condition(Coin target, double price, String relation) {
        this.target = target;
        this.price = price;
        this.relation = relation;
    }

    public Boolean evaluate() {
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
