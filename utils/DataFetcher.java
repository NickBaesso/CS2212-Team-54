package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Retrieves data from coingecko database.
 * @author Jiangqi
 */
public class DataFetcher extends FetcherStrategy {
	/**
	 * Return the crypto currency values and stores them in a json object
	 * @param id
	 * @param date
	 * @return return a json with all coin data.
	 */
	protected JsonObject getDataForCrypto(DataContext context, String id, String date) {
		String urlString = String.format("https://api.coingecko.com/api/v3/coins/%s/history?date=%s", id, date);
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				JsonObject jsonObject = new JsonParser().parse(inline).getAsJsonObject();
				return jsonObject;
			}

		} catch (IOException e) {
			System.out.println("Something went wrong with the API call.");
		}
		return null;
	}

	/**
	 * This method returns the price with
	 * the given identifier and date
	 * @param id
	 * @param date
	 * @return return the price in CAD for the specified crypto
	 */
	protected double getPriceForCoin(DataContext context, String id, String date) {
		double price = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(null, id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("current_price").getAsJsonObject();
			price = currentPrice.get("cad").getAsDouble();
		}
		
		return price;
	}

	/**
	 * This method returns the market cap
	 * for the coin with the specified parameters.
	 * @param id
	 * @param date
	 * @return the market cap of the specified coin.
	 */
	public double getMarketCapForCoin(String id, String date) {
		double marketCap = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(null, id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("market_cap").getAsJsonObject();
			marketCap = currentPrice.get("cad").getAsDouble();
		}
		
		return marketCap;
	}

	/**
	 * return the volume of the coin specified.
	 * @param id
	 * @param date
	 * @return coin volume.
	 */
	public double getVolumeForCoin(String id, String date) {
		double volume = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(null, id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("total_volume").getAsJsonObject();
			volume = currentPrice.get("cad").getAsDouble();
		}
		
		return volume;
	}

	public static void main(String[] args) {
		//DataFetcher fetcher = new DataFetcher();
		//double price = fetcher.getPriceForCoin("bitcoin", "08-09-2021");
		//double marketCap = fetcher.getMarketCapForCoin("bitcoin", "08-09-2021");
		//double volume = fetcher.getVolumeForCoin("bitcoin", "08-09-2021");
		
		//System.out.println("Bitcoin=>\tPrice: " + price +  "\n\t\tMarket Cap: " + marketCap +  "\n\t\tVolume: "+volume);
		
	}
}
