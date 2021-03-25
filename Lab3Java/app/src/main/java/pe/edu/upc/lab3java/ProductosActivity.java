package pe.edu.upc.lab3java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProductosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
    }

    public void mostrarSiguiente(View view) {
        EditText et1 = view.findViewById(R.id.editTextTextPersonName);
        String mytxt = et1.getText().toString();

        Intent i = new Intent(this, PedidosActivity.class);
        i.putExtra("TOKEN", "mytoken123");
        i.putExtra("Direccion", mytxt);
        i.putExtra("LANGUAGE", "ES");
        startActivity(i);
    }
}