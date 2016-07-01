package jlexdev.com.recyclerview;

/**
 * Created by JLex on 30/06/16.
 * [CONSTRUCTOR]
 */

public class Movies {

    private int imageMovie;
    private String nameMovie;

    public Movies(int imageMovie, String nameMovie) {
        this.imageMovie = imageMovie;
        this.nameMovie = nameMovie;
    }

    public int getImageMovie() {
        return imageMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }
}
