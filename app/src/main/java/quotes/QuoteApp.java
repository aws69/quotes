package quotes;

import java.util.Random;

public class QuoteApp {
    public static void main(String[] args) {
        Quote randomQuote;

        if (args.length > 0 && args[0].equalsIgnoreCase("local")) {

            randomQuote = getRandomQuoteFromFile();
        } else {

            randomQuote = QuoteAPI.getRandomQuoteFromAPI();
            if (randomQuote != null) {

                cacheQuoteToFile(randomQuote);
            }
        }

        if (randomQuote != null) {
            System.out.println("Quote: " + randomQuote.getBody());
            System.out.println("Author: " + randomQuote.getAuthor());
        } else {
            System.out.println("No quotes found.");
        }
    }

    private static Quote getRandomQuoteFromFile() {


    }

    private static void cacheQuoteToFile(Quote quote) {

    }
}
