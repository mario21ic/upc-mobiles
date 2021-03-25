package pe.edu.upc.lab3kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun callSpinner(view: View) {
        Log.i("===", "Click de procesar!")
        val intent = Intent(this, SpinnerExampleActivity::class.java)
        startActivity(intent)
    }

    fun callGeneroCanciones(view: View) {
        Log.i("===", "Click de procesar!")
        val intent = Intent(this, GeneroCancionesActivity::class.java)
        startActivity(intent)
    }

    fun callAgenda(view: View) {
        Log.i("===", "Click de procesar!")
        val intent = Intent(this, AgendaActivity::class.java)
        startActivity(intent)
    }

    fun callPeliculas(view: View) {
        Log.i("===", "Click de procesar!")
        val intent = Intent(this, PeliculasActivity::class.java)
        startActivity(intent)
    }
}