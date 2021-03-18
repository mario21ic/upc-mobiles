package com.mario21ic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class ProductosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_inicio -> {
                Log.i("===", "Click de Inicio!")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_productos -> {
                Log.i("===", "Click de Productos!")
                val intent = Intent(this, ProductosActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_servicios -> {
                Log.i("===", "Click de Servicios!")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}