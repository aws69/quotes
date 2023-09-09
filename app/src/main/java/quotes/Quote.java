package quotes;

public class Quote {
    private String information;
    Information quote  ;

    public String getInformation() {
        return information;
    }
    public Information getquote() {
        return quote;
    }



    @Override
    public String toString() {
        return "Quote{" +
                "qotd_date='" + information + '\'' +
                ", quote=" + quote +
                '}';
    }

}
