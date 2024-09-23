package Fetch;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

	public class FetchResponse {

	    private static final String[] SOURCES = {
	        "https://api.exchangerate-api.com/v4/latest/USD",
	        "https://api.exchangeratesapi.io/latest",
	        "https://open.er-api.com/v6/latest/USD",
	        "https://api.exchangerate.host/latest",
	        "https://v6.exchangerate-api.com/v6/YOUR_API_KEY/latest/USD"
	    };

	    public static void main(String[] args) {
	        try {
	            fetchExchangeRates("USD", "EUR");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void fetchExchangeRates(String sourceCurrency, String targetCurrency) throws Exception {
	        HttpClient client = HttpClient.newHttpClient();
	        ObjectMapper objectMapper = new ObjectMapper();
	        Map<String, Double> aggreRates = new HashMap<>();

	        for (String source : SOURCES) {
	            try {
	                HttpRequest request = HttpRequest.newBuilder()
	                        .uri(URI.create(source))
	                        .build();
	                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	                double exchangeRate = parseExchangeRate(response.body(), source, targetCurrency, objectMapper);
	                aggreRates.put(source, exchangeRate);
	            } catch (Exception e) {
	                System.out.println("Failed to fetch from: " + source);
	            }
	        }

	        String fastestSource = aggreRates.keySet().iterator().next();
	        System.out.println("Fastest Response: " + fastestSource + " -> " + aggreRates.get(fastestSource));
	        System.out.println("Aggregated Rates: " + aggreRates);
	    }

	    private static double parseExchangeRate(String jsonResponse, String sourceCurrency, String targetCurrency, ObjectMapper objectMapper) throws Exception {
	        Map<String, Object> jsonMap = objectMapper.readValue(jsonResponse, Map.class);
	        Map<String, Double> rates = (Map<String, Double>) jsonMap.get("rates");
	        return rates.getOrDefault(targetCurrency, 0.0);
	    }
	}



