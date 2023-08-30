package quotes;

import java.util.Random;

public class QuoteApp {
    public static void main(String[] args) {
        Quote randomQuote;

        if (args.length > 0 && args[0].equalsIgnoreCase("local")) {
            // Fetch a quote from your local file
            randomQuote = getRandomQuoteFromFile();
        } else {
            // Fetch a quote from the API
            randomQuote = QuoteAPI.getRandomQuoteFromAPI();
            if (randomQuote != null) {
                // Cache the quote to your local file
                cacheQuoteToFile(randomQuote);
            }
        }

        if (randomQuote != null) {
            System.out.println("Quote: " + randomQuote.getQuoteText());
            System.out.println("Author: " + randomQuote.getAuthor());
        } else {
            System.out.println("No quotes found.");
        }
    }

    private static Quote getRandomQuoteFromFile() {
        // Implement logic to read a random quote from your local file
    }

    private static void cacheQuoteToFile(Quote quote) {
        // Implement logic to append the quote to your local file
    }
}
