package jlexdev.com.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JLex on 30/06/16.
 * [VIEWHOLDER]
 */
public class MoviesHolder extends RecyclerView.ViewHolder {

    private ImageView imgImageMovie;
    private TextView tvNameMovie;

    public MoviesHolder(View itemView) {
        super(itemView);

        imgImageMovie = (ImageView)itemView.findViewById(R.id.img_image_movie);
        tvNameMovie = (TextView)itemView.findViewById(R.id.tv_name_movie);
    }

    public void bindMovies(Movies item) {

        imgImageMovie.setImageResource(item.getImageMovie());
        tvNameMovie.setText(item.getNameMovie());
    }
}
