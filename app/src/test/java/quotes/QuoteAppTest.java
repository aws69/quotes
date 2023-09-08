package quotes;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class QuoteAppTest {

    @Test
    void toStringReturnRandomQuoteAndItsAuthor() {
        try {
            Quote[] quotes = QuoteApp.parseJsonFile();


            assertNotNull(quotes);

            Quote randomQuote = QuoteApp.getRandomQuote(quotes);

            assertNotNull(randomQuote);
            assertNotNull(randomQuote.getQuote());
            assertNotNull(randomQuote.getAuthor());

            String randomQuoteAsString = randomQuote.toString();

            assertNotNull(randomQuoteAsString);

            System.out.println("Quote: " + randomQuote.getQuote());
            System.out.println("Author: " + randomQuote.getAuthor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}