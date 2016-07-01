package jlexdev.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerMovies;
    private RecyclerView.Adapter adapterMovies;
    private RecyclerView.LayoutManager layoutManagerMovies;

    private ArrayList<Movies> data;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cargo DATOS
        data = new ArrayList<Movies>();

        data.add(new Movies(R.drawable.img_alvin, "Alvin y las Ardillas"));
        data.add(new Movies(R.drawable.img_angry, "Angry Birds"));
        data.add(new Movies(R.drawable.img_cazador, "El Cazador y la Reina del Hielo"));
        data.add(new Movies(R.drawable.img_civilwar, "Civil War"));
        data.add(new Movies(R.drawable.img_deadpool, "Deadpool"));
        data.add(new Movies(R.drawable.img_dioses, "Dioses de Egipto"));
        data.add(new Movies(R.drawable.img_era, "La era de Hielo 5"));
        data.add(new Movies(R.drawable.img_jobs, "Steve Jobs"));
        data.add(new Movies(R.drawable.img_panda, "kung Fu Panda"));
        data.add(new Movies(R.drawable.img_xmen, "X-Men Apocalipsis"));

        // RecyclerView
        recyclerMovies = (RecyclerView)findViewById(R.id.recycler_movies);
        recyclerMovies.setHasFixedSize(true);

        // Adapter
        adapterMovies = new MoviesAdapter(data);
        recyclerMovies.setAdapter(adapterMovies);

        // Layout Manager
        layoutManagerMovies = new GridLayoutManager(this, 2);
        recyclerMovies.setLayoutManager(layoutManagerMovies);
    }
}
