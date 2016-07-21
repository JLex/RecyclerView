package jlexdev.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

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

//      layoutManagerMovies = new LinearLayoutManager(this);

//      layoutManagerMovies = new StaggeredGridLayoutManager(3, 1);
//      layoutManagerMovies = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        recyclerMovies.setLayoutManager(layoutManagerMovies);



        /** Evento
         *
         *  Fuente:
         *  https://www.learn2crack.com/2016/02/android-recyclerview-and-cardview.html
         */
/*
       Para manejar los clicks en elemento de la lista RecyclerView
       adjuntamos RecyclerView.OnItemTouchListener() de la interfaz.
       El click se puede manejar en el método onInterceptTouchEvent().
       Utilizamos GestureDetector para detectar si se trata de un solo toque.
       La posición de click puede ser obtenida llamando método getChildAdapterPosition()
       en el objeto RecyclerView pasando el objeto child del View.
       El View child se puede obtener con el método findChildViewUnder().
*/

        // Evento
        recyclerMovies.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(){


            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(),
                    new GestureDetector.SimpleOnGestureListener(){

                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            return true;
                        }
                    });

            // 3 Métodos
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());

                if(child != null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(child);
                    // No me muestra la posición TODO: Corregir Error
                    Toast.makeText(getApplicationContext(), "" + data.get(position), Toast.LENGTH_SHORT).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }

        });

    }
}
