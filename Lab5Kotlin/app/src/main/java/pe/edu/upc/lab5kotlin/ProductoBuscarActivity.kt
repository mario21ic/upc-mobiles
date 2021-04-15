package pe.edu.upc.lab5kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class ProductoBuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_buscar)
    }

    fun buscar(view:View) {

        val txtCriterio = findViewById<View>(R.id.txtCriterio) as EditText
        val criterio = txtCriterio.text.toString()
        val url = "http://condeleron.atwebpages.com/index.php/productos/$criterio"

        val stringRequest = StringRequest(Request.Method.GET, url, { response->
            try {
                val jsonArray = JSONArray(response)
                Log.i("======>", jsonArray.toString())
                val items: MutableList<String?> = ArrayList()

                for (i in 0 until jsonArray.length()) {
                    val vv = jsonArray.getJSONObject(i)
                    items.add(vv.getString("nombre") + " (S/. " + vv.getString("precio") + ") ")
                }

                val lstProductos: ListView = findViewById(R.id.lista)
                val adaptador: ArrayAdapter<String?> = ArrayAdapter<String?>(
                    this@ProductoBuscarActivity,
                    android.R.layout.simple_list_item_1,
                    items)
                lstProductos.adapter = adaptador
            } catch (e: JSONException) {
                Log.i("======>", e.message.toString())
            }
        },
            {error->
                Log.i("======>", error.toString())
            }
        )
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }

    fun gotoRegistrar(view: View) {
        val intent = Intent(this@ProductoBuscarActivity, ProductoRegistrarActivity::class.java)
        startActivity(intent)
    }
}