package quotes;

import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class QuoteAPIResponse {
    @SerializedName("quote")
    private Quote quote;

    public Quote getQuote() {
        return quote;
    }
}
