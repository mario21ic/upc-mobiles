package pe.edu.upc.lab5java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnGet(View view) {
        startActivity(new Intent(MainActivity.this, ProductosBuscarActivity.class));
    }

    public void btnPost(View view) {
        startActivity(new Intent(MainActivity.this, ProductoRegistrarActivity.class));
    }
}