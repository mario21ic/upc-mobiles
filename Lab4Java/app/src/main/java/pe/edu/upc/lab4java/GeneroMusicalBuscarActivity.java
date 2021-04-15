package pe.edu.upc.lab4java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GeneroMusicalBuscarActivity extends AppCompatActivity {

    ArrayList<GeneroMusical> resultados = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genero_musical_buscar);
    }

    public void buscar(View view) {
        EditText criterio = (EditText) findViewById(R.id.criterio);
        GeneroMusicalDAO dao = new GeneroMusicalDAO(getBaseContext());
        try {
            resultados = dao.buscar(criterio.getText().toString());

            String[] encontrados = new String[resultados.size()];
            int i = 0;
            for (GeneroMusical gm : resultados){
                encontrados[i++] = gm.getTitulo() + " | " + gm.getDescripcion();
            }

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this.getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    encontrados);

            ListView listaResultados = (ListView)findViewById(R.id.listaResultados);
            listaResultados.setAdapter(adaptador);
            registerForContextMenu(listaResultados);

        } catch (DAOException e) {
            Log.i("GeneroMusicalBuscarAc", "====> " + e.getMessage());
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Seleccione una acción:");
        menu.add(0,v.getId(),0,"Editar");
        menu.add(0,v.getId(),0,"Eliminar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Eliminar") {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            int index = info.position;
            GeneroMusical gm = resultados.get(index);
            Log.i("====>",gm.getTitulo()+"");
            GeneroMusicalDAO dao = new GeneroMusicalDAO(getBaseContext());
            try {
                dao.eliminar(gm.getId());
                Toast.makeText(this,"Se eliminó",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(getIntent());
            } catch (DAOException e) {
                Log.i("GeneroMusicalBuscarAc", "====> " + e.getMessage());
            }
        } else if (item.getTitle() == "Editar") {
            Toast.makeText(this,"Editar...",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}