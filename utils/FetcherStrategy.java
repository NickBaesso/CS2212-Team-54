package utils;

import com.google.gson.JsonObject;

public abstract class FetcherStrategy {
    protected abstract JsonObject getDataForCrypto(DataContext context, String id, String date);
    protected abstract double getPriceForCoin(DataContext context, String id, String date);
}
