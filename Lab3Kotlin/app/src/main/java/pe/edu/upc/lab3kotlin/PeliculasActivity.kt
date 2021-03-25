package pe.edu.upc.lab3kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PeliculasActivity : AppCompatActivity() {

    private val peliculaList: ArrayList<Pelicula> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var mAdapter: PeliculasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas)

        recyclerView = findViewById(R.id.recycler_view)
        mAdapter = PeliculasAdapter(peliculaList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = mAdapter
        preparePeliculaData()

    }

    private fun preparePeliculaData() {
        var pelicula = Pelicula("Mad Max: Fury Road", "Action & Adventure", "2015")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Inside Out", "Animation, Kids & Family", "2015")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Star Wars: Episode VII - The Force Awakens", "Action", "2015")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Shaun the Sheep", "Animation", "2015")
        peliculaList.add(pelicula)
        pelicula = Pelicula("The Martian", "Science Fiction & Fantasy", "2015")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Mission: Impossible Rogue Nation", "Action", "2015")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Up", "Animation", "2009")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Star Trek", "Science Fiction", "2009")
        peliculaList.add(pelicula)
        pelicula = Pelicula("The LEGO Pelicula", "Animation", "2014")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Iron Man", "Action & Adventure", "2008")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Aliens", "Science Fiction", "1986")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Chicken Run", "Animation", "2000")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Back to the Future", "Science Fiction", "1985")
        peliculaList.add(pelicula)
        pelicula = Pelicula("Goldfinger", "Action & Adventure", "1965")
        peliculaList.add(pelicula)

        mAdapter.notifyDataSetChanged()
    }


}