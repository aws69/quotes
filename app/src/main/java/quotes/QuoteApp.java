package quotes;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class QuoteApp {
    public static void main(String[] args) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("recentquotes.json")) {
            Quote[] quotes = gson.fromJson(reader, Quote[].class);

            if (quotes != null && quotes.length > 0) {
                Random random = new Random();
                int randomIndex = random.nextInt(quotes.length);
                Quote randomQuote = quotes[randomIndex];

                System.out.println("Quote: " + randomQuote.getQuoteText());
                System.out.println("Author: " + randomQuote.getAuthor());
            } else {
                System.out.println("No quotes found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
