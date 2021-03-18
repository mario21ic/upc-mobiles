package com.mario21ic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_inicio:
                Log.i("====>","Click en Inicio!!");
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.menu_productos:
                Log.i("====>","Click en Productos!!");
                startActivity(new Intent(this, ProductosActivity.class));
                return true;
            case R.id.menu_servicios:
                Log.i("====>","Click en Servicios!!");
                startActivity(new Intent(this, ScrollActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}