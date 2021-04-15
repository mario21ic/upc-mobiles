package pe.edu.upc.lab4java

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnInsertar(view: View) {
        Toast.makeText(this@MainActivity, "Click on Insertar", Toast.LENGTH_SHORT).show()
        Log.i("#####", "Click on Insertar!")
        startActivity(Intent(this, GeneroMusicalNuevoActivity::class.java))
    }

    fun btnBuscar(view: View) {
        Toast.makeText(this@MainActivity, "Click on Buscar", Toast.LENGTH_SHORT).show()
        Log.i("#####", "Click on Buscar!")
        startActivity(Intent(this, GeneroMusicalBuscarActivity::class.java))
    }

    fun btnEscribirSP(view: View) {
        Toast.makeText(this@MainActivity, "Click on EscribirSP", Toast.LENGTH_SHORT).show()
        Log.i("#####", "Click on EscribirSP!")
        startActivity(Intent(this, EscribirPreferenciaActivity::class.java))
    }

    fun btnLeerSP(view: View) {
        Toast.makeText(this@MainActivity, "Click on LeerSP", Toast.LENGTH_SHORT).show()
        Log.i("#####", "Click on LeerSP!")
        startActivity(Intent(this, LeerPreferenciaActivity::class.java))
    }
}