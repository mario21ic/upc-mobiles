package pe.edu.upc.lab4java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EscribirPreferenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir_preferencia);
    }

    public void guardarPreferencia(View view) {
        EditText nombreShared = (EditText) findViewById(R.id.nombreShared);
        EditText valorShared = (EditText) findViewById(R.id.valorShared);
        SharedPreferences prefs = getSharedPreferences("PREFERENCIAS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        GregorianCalendar c = new GregorianCalendar();
        editor.putString(nombreShared.getText().toString(), valorShared.getText().toString());
        editor.putString("user", "mario21ic");
        editor.commit();
        Toast toast= Toast.makeText(getApplicationContext(), "Dato grabado en el SharedPreferences", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

}