package quotes;

import com.google.gson.annotations.SerializedName;

public class QuoteAPIResponse {
    @SerializedName("quote")
    private Quote quote;

    public Quote getQuote() {
        return quote;
    }
}
