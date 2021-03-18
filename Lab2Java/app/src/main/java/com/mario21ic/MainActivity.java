package com.mario21ic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        // Llamar a Principal
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
//                startActivity(intent);
//            }
//        }, 2000);
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

    public void btnClickeame(View view) {
        Toast t = Toast.makeText(getApplicationContext(), "Acabas de presionar Clickeame", Toast.LENGTH_LONG);
        t.setGravity(Gravity.BOTTOM | Gravity.RIGHT, 0,0);
        t.show();
    }

    public void btnProductos(View view) {
        setContentView(R.layout.activity_productos);
    }

    public void btnScroll(View view) {
        setContentView(R.layout.activity_scroll_activity);
    }

}
