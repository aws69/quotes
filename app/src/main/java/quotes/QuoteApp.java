package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
public class QuoteApp {
    public static void main(String[] args) {
        fetchAndSerializeQuoteData();
    }

    public static void fetchAndSerializeQuoteData() {
        URL quotUrl=null;

        try{
            quotUrl = new URL("https://favqs.com/api/qotd");

            HttpURLConnection quoteUrlConnection = (HttpURLConnection) quotUrl.openConnection();
            quoteUrlConnection.setRequestMethod("GET");
            InputStreamReader reader = new InputStreamReader(quoteUrlConnection.getInputStream());
            BufferedReader quoteBufferReader = new BufferedReader(reader);
            String quoteData = quoteBufferReader.readLine();
            System.out.println(quoteData);

            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            Quote ditto = gson.fromJson(quoteData, Quote.class);

            File dittoFile = new File("\\\\wsl$\\Ubuntu\\home\\aws\\quotes\\app\\src\\main\\resources\\ditto.json");
            try (FileWriter writeToDittoFile= new FileWriter(dittoFile)){
                gson.toJson(ditto, writeToDittoFile);
            }

        }catch (IOException e){
            System.out.println("invalid URl: "+quotUrl);
            e.printStackTrace();
        }
    }
}
