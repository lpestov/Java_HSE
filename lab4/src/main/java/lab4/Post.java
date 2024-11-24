package lab4;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;
    private String link;

    // т.к comment_count не в CamelCase, то используем @SerializedName
    @SerializedName("comment_count")
    private int commentCount;


    @Override
    public String toString() {
        return "Post ID: " + id +
                "\nUser ID: " + userId +
                "\nTitle: " + title +
                "\nBody: " + body +
                "\nLink: " + link +
                "\nComment Count: " + commentCount + "\n";
    }
}
