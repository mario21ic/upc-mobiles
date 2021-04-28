package pe.edu.upc.lab3kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_inicio -> {
                Log.i("===", "Click de Inicio!")
                return true
            }
            R.id.menu_perfil -> {
                Log.i("===", "Click de Perfil!")
                return true
            }
            R.id.menu_logout -> {
                Log.i("===", "Click de Logout!")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}