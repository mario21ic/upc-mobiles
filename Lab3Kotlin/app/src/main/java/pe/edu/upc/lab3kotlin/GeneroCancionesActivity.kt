package pe.edu.upc.lab3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class GeneroCancionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genero_canciones)

        val lstProductos = findViewById<ListView>(R.id.lstGeneros)
        val matriz: ArrayList<String> = ArrayList()
        matriz.add("Pop")
        matriz.add("Punk")
        matriz.add("Música Clásica")
        matriz.add("Opera")
        matriz.add("Rock")
        matriz.add("Salsa")

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, matriz)
        lstProductos.adapter = adaptador;

        lstProductos.onItemClickListener =
            AdapterView.OnItemClickListener { adapter, v, position, arg3 ->
                val value = adapter.getItemAtPosition(position) as String
                Toast.makeText(this, "Hizo click en: $value", Toast.LENGTH_SHORT).show()
            }
    }
}