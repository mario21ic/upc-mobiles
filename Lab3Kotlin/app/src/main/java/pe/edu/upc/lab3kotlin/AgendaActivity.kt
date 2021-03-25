package pe.edu.upc.lab3kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter

class AgendaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda)

        val from = arrayOf("Time", "Name", "Desc")
        val to = intArrayOf(R.id.hora, R.id.nombre, R.id.desc1)

        val lista = ArrayList<Array<String>>()

        val evento1 = arrayOf("11:30", "Reunión de coordinación", "Lugar: Auditorio", "1")
        val evento2 = arrayOf("12:00", "Almuerzo", "Lugar: Comedor central", "2")
        val evento3 = arrayOf("14:00", "Tiro al blanco", "Lugar: Oficina", "3")

        lista.add(evento1);
        lista.add(evento2);
        lista.add(evento3);

        val eventos = ArrayList<HashMap<String, String>>()

        for (evento in lista) {
            val datosEvento = HashMap<String, String>()
            datosEvento["Time"] = evento[0]
            datosEvento["Name"] = evento[1]
            datosEvento["Desc"] = evento[2]
            datosEvento["id"] = evento[3]
            eventos.add(datosEvento)
        }

        val listadoAdapter = SimpleAdapter(this, eventos, R.layout.agenda_fila, from, to)
        val lv = findViewById<ListView>(R.id.lista1)
        lv.setAdapter(listadoAdapter)
    }
}