package pe.edu.upc.lab4java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LeerPreferenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer_preferencia);
    }

    public void buscarPreferencia(View v){
        EditText nombreShared = (EditText) findViewById(R.id.nombreShared);
        SharedPreferences prefs = getSharedPreferences("PREFERENCIAS", Context.MODE_PRIVATE);
        String cadena = prefs.getString(nombreShared.getText().toString(), "");
        TextView textView1 = (TextView)findViewById(R.id.resultadoShared);
        textView1.setText(cadena);
    }
}