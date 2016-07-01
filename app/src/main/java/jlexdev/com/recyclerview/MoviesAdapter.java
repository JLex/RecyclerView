package jlexdev.com.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by JLex on 30/06/16.
 * [ADAPTER]
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesHolder> {

    private ArrayList<Movies> data;

    public MoviesAdapter(ArrayList<Movies> data) {
        this.data = data;
    }

    /** 3 Métodos de Adapter */
    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_movies, parent, false);

        MoviesHolder mh = new MoviesHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {

        Movies item = data.get(position);
        holder.bindMovies(item);
    }

    @Override
    public int getItemCount() {

        return data.size();
    }
}
