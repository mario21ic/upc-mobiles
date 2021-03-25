package pe.edu.upc.lab3java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class PedidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        Intent intent = getIntent();
        String token = intent.getStringExtra("TOKEN");
        String direccion = intent.getStringExtra("Direccion");
        Log.i("===========>", token);
        Log.i("===========>", direccion);
    }
}