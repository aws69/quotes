package quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuoteAPI {
    private static final String API_URL = "https://favqs.com/api/qotd";

    public static Quote getRandomQuoteFromAPI() {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            reader.close();

            // Parse the JSON response and create a Quote object
            // Implement JSON parsing logic here
            // Example: Using GSON library
            QuoteAPIResponse quoteAPIResponse = gson.fromJson(response, QuoteAPIResponse.class);
            return new Quote(quoteAPIResponse.getQuote().getBody(), quoteAPIResponse.getQuote().getAuthor());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
