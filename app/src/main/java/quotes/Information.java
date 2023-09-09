package quotes;

import java.util.ArrayList;

public class Information {
    int id ;
    boolean dialogue;
    boolean  favorite;
    private ArrayList<String> tags;
    private String  url;
    private int favorites_count;
    private int  upvotes_count;
    private int  downvotes_count;
    private String author;
    private  String author_permalink;
    private  String body;

    @Override
    public String toString() {
        return "Information{" +
                "id='" + id + '\'' +
                ", favorites_count=" + favorites_count +
                ", dialogue=" + dialogue +
                ", favorite=" + favorite +
                ", tags=" + tags +
                ", url='" + url + '\'' +
                ", upvotes_count=" + upvotes_count +
                ", downvotes_count=" + downvotes_count +
                ", author='" + author + '\'' +
                ", author_permalink='" + author_permalink + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

}
