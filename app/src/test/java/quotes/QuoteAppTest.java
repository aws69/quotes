package quotes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class QuoteAppTest {
    @Test
    void testQuoteAppOutput() {
        // Redirect standard output to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Execute the main method of QuoteApp
        QuoteApp.main(new String[]{});

        // Restore standard output
        System.setOut(originalOut);

        // Convert the captured output to a string
        String printedOutput = outputStream.toString().trim();

        // Assertions
        assertNotNull(printedOutput);
        assertTrue(printedOutput.contains("Quote: "));
        assertTrue(printedOutput.contains("Author: "));
    }
}
