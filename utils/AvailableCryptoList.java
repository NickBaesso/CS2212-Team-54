package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import infrastructure.Coin;

/**
 * This class is responsible for the retrieving crypto
 * coin data from the coin gecko website.
 *
 * @author Original: Kostas Kontogiannis, Modifications: Jiangqi
 */
public class AvailableCryptoList {
	private static AvailableCryptoList instance = null;

	private Map<String, Coin> availableCryptosMap = new HashMap<>();
	private List<Coin> availableCryptosList = new ArrayList<>();

	public static AvailableCryptoList getInstance() {  // Singleton
		if (instance == null)
			instance = new AvailableCryptoList();

		return instance;
	}

	private AvailableCryptoList() {
		findAvailableCryptos();
	}

	public void call() {
		String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=VNEY4VV2AWF1EB51";
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
				System.out.println(inline);
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();
//				
				String name, id;
				for (int i = 0; i < size; i++) {
//					JsonObject object = jsonArray.get(i).getAsJsonObject();
//					name = object.get("name").getAsString();
//					id = object.get("id").getAsString();
//
//					availableCryptosMap.put(name, id);
//					availableCryptosList.add(name);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}

	private void findAvailableCryptos() {

		String urlString =
				"https://api.coingecko.com/api/v3/coins/markets" +
						"?vs_currency=cad&order=market_cap_desc&per_page=100&page=1&sparkline=false";
//		ALPHAVANTAGE API KEY = VNEY4VV2AWF1EB51
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
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();

				String name, symbol, id;
				double price;
				for (int i = 0; i < size; i++) {
					JsonObject object = jsonArray.get(i).getAsJsonObject();
					name = object.get("name").getAsString();
					symbol = object.get("symbol").getAsString();
					id = object.get("id").getAsString();
					price = object.get("current_price").getAsDouble();


					Coin coin = new Coin(name, symbol, id, price);


					availableCryptosMap.put(symbol, coin);
					availableCryptosList.add(coin);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}

	public Coin [] getAvailableCryptos() {
		return availableCryptosList.toArray(new Coin[availableCryptosList.size()]);
	}

	public String getCryptoID(String cryptoName) {
		return availableCryptosMap.get(cryptoName).getID();
	}

	public HashMap<String, Coin> getMap() {
		if (availableCryptosMap.isEmpty())
			findAvailableCryptos();
		return (HashMap<String, Coin>) availableCryptosMap;
	}

	public static void main(String[] args) throws Exception {
		Coin[] list = getInstance().getAvailableCryptos();
		for (Coin coin : list)
			System.out.printf("%s: %f\n", coin.getSymbol(), coin.getPrice());
	}

}
