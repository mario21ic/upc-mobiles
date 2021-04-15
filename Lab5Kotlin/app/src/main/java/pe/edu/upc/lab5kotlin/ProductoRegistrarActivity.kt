package pe.edu.upc.lab5kotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.Exception


class ProductoRegistrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto_registrar)
    }

    fun registrar(view: View) {

        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtPrecio = findViewById<EditText>(R.id.txtPrecio)
        val url = "http://condeleron.atwebpages.com/index.php/productos"

        val requestQueue = Volley.newRequestQueue(this)

        val stringRequest = object:StringRequest(Method.POST, url,
            Response.Listener {
                    response->
                try {
                    Log.i("======>", response.toString())
                    Toast.makeText(this@ProductoRegistrarActivity,"Se insertó correctamente",Toast.LENGTH_LONG).show()
                }
                catch (e:Exception){
                    Log.i("======>", e.toString())
                }
            },
            Response.ErrorListener { error -> Log.i("======>", "Error-> $error.toString()") }
        )
        {
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params["nombre"] = txtNombre.text.toString()
                params["precio"] = txtPrecio.text.toString()
                return params
            }
        }

        requestQueue.add(stringRequest)
    }
}