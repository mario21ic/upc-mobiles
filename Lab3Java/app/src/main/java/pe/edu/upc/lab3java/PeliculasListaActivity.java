package pe.edu.upc.lab3java;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PeliculasListaActivity extends AppCompatActivity {

    private List<Pelicula> peliculaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PeliculasAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas_lista);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new PeliculasAdapter(peliculaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        recyclerView.setAdapter(mAdapter);

        preparePeliculaData();
    }

    private void preparePeliculaData() {
        Pelicula pelicula = new Pelicula("Mad Max: Fury Road", "Action & Adventure", "2015");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Inside Out", "Animation, Kids & Family", "2015");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Shaun the Sheep", "Animation", "2015");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("The Martian", "Science Fiction & Fantasy", "2015");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Mission: Impossible Rogue Nation", "Action", "2015");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Up", "Animation", "2009");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Star Trek", "Science Fiction", "2009");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("The LEGO Pelicula", "Animation", "2014");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Iron Man", "Action & Adventure", "2008");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Aliens", "Science Fiction", "1986");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Chicken Run", "Animation", "2000");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Back to the Future", "Science Fiction", "1985");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Raiders of the Lost Ark", "Action & Adventure", "1981");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Goldfinger", "Action & Adventure", "1965");
        peliculaList.add(pelicula);

        pelicula = new Pelicula("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        peliculaList.add(pelicula);

        mAdapter.notifyDataSetChanged();
    }

}