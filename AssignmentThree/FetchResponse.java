package Fetch;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;
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
        fetchExchangeRates("USD", "EUR");
    }

    public static void fetchExchangeRates(String sourceCurrency, String targetCurrency) {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        List<CompletableFuture<Map<String, Double>>> futures = new ArrayList<>();

        for (String source : SOURCES) {
            CompletableFuture<Map<String, Double>> future = CompletableFuture.supplyAsync(() -> {
                try {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(source))
                            .build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    
                    if (response.statusCode() != 200) {
                        System.out.println("Failed to fetch from: " + source + " - Status code: " + response.statusCode());
                        return Collections.emptyMap();
                    }

                    return parseExchangeRate(response.body(), targetCurrency, objectMapper);
                } catch (Exception e) {
                    System.out.println("Failed to fetch from: " + source + " - " + e.getMessage());
                    return Collections.emptyMap();
                }
            });
            futures.add(future);
        }

      
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.thenRun(() -> {
            Map<String, Double> aggregatedRates = new HashMap<>();
            for (int i = 0; i < SOURCES.length; i++) {
                try {
                    Map<String, Double> result = futures.get(i).get();
                    if (!result.isEmpty()) {
                        aggregatedRates.put(SOURCES[i], result.get(targetCurrency));
                    }
                } catch (Exception e) {
                    System.out.println("Error retrieving result from: " + SOURCES[i] + " - " + e.getMessage());
                }
            }

            
            if (!aggregatedRates.isEmpty()) {
                String fastestSource = aggregatedRates.keySet().iterator().next();
                System.out.println("Fastest Response: " + fastestSource + " -> " + aggregatedRates.get(fastestSource));
            } else {
                System.out.println("No valid responses received.");
            }

            System.out.println("Aggregated Rates: " + aggregatedRates);
        }).join(); 
    }

    private static Map<String, Double> parseExchangeRate(String jsonResponse, String targetCurrency, ObjectMapper objectMapper) throws Exception {
        Map<String, Object> jsonMap = objectMapper.readValue(jsonResponse, Map.class);
        Map<String, Double> rates = (Map<String, Double>) jsonMap.get("rates");

        Map<String, Double> result = new HashMap<>();
        if (rates != null) {
            result.put(targetCurrency, rates.getOrDefault(targetCurrency, 0.0));
        } else {
            System.out.println("Rates are null in the response.");
        }
        return result;
    }
}
