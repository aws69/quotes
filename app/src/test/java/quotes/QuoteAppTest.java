package quotes;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({QuoteApp.class, URL.class, HttpURLConnection.class, BufferedReader.class, FileWriter.class})
public class QuoteAppTest {

    @Test
    public void testFetchAndSerializeQuoteData_Success() throws Exception {
        // Mock the URL and HttpURLConnection
        URL mockUrl = PowerMockito.mock(URL.class);
        HttpURLConnection mockConnection = PowerMockito.mock(HttpURLConnection.class);

        // Mock the BufferedReader and Gson
        BufferedReader mockReader = PowerMockito.mock(BufferedReader.class);
        Gson mockGson = PowerMockito.mock(Gson.class);

        // Mock the FileWriter
        FileWriter mockFileWriter = PowerMockito.mock(FileWriter.class);

        // Mock the System.out for console output
        PrintStream mockConsole = PowerMockito.mock(PrintStream.class);
        System.setOut(mockConsole);


        PowerMockito.whenNew(URL.class).withArguments("https://favqs.com/api/qotd").thenReturn(mockUrl);
        PowerMockito.when(mockUrl.openConnection()).thenReturn(mockConnection);
        PowerMockito.when(mockConnection.getInputStream()).thenReturn(new ByteArrayInputStream("sample_quote_data".getBytes()));
        PowerMockito.whenNew(BufferedReader.class).withArguments(any(Reader.class)).thenReturn(mockReader);
        when(mockReader.readLine()).thenReturn("sample_quote_json").thenReturn(null);

        PowerMockito.whenNew(Gson.class).withNoArguments().thenReturn(mockGson);
        when(mockGson.fromJson(anyString(), eq(Quote.class))).thenReturn(new Quote());

        PowerMockito.whenNew(FileWriter.class).withArguments("\\\\wsl$\\Ubuntu\\home\\aws\\quotes\\app\\src\\main\\resources\\ditto.json").thenReturn(mockFileWriter);

        // Act
        QuoteApp.fetchAndSerializeQuoteData();

        // Assert
        verify(mockConsole).println("sample_quote_json"); // Verify that the console output is printed

    }
}
