package structure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Coin {
    private String name;
    private double price;
    private String code; // BTC, USDT, etc.

    Coin(String name, String code, double price) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Boolean equals(Coin coin) {
        return (coin.getName().equals(name) || coin.getCode().equals(code));
    }

    public Boolean equals(String name) {
        return (this.name.equals(name) || this.code.equals(name));
    }

    public void updatePrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Coin btc = new Coin("Bitcoin", "BTC", 1.1);
        Coin anotherBTC = new Coin("Bitcoin", "BTC", 1.6);
        System.out.println(new SimpleDateFormat("dd-MMMM-yyyy").format(new Date()));
    }
}
