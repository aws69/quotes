package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class QuoteApp {

    static Quote[] parseJsonFile() throws IOException {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader("recentquotes.json"))) {
            return gson.fromJson(reader, Quote[].class);
        }
    }

    public static Quote getRandomQuote(Quote[] quotes) {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.length);
        return quotes[randomIndex];
    }
}
