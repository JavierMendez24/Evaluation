package personal.app.evaluation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import personal.app.evaluation.model.Encuestado;

import static personal.app.evaluation.MainActivity.encuestados;

public class ListaEncuestadosActivity extends AppCompatActivity {

    ListView lsvEncuestados;
    TextView txvCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_encuestados);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lsvEncuestados = (ListView)findViewById(R.id.lsvEncuestados);
        txvCantidad = (TextView)findViewById(R.id.txvCantidad);

        ArrayAdapter<Encuestado> adapterEncuestado = new ArrayAdapter(this, android.R.layout.simple_list_item_1, encuestados);

        lsvEncuestados.setAdapter(adapterEncuestado);

        adapterEncuestado.notifyDataSetChanged();

        txvCantidad.setText("Cantidad de encuestados: " + encuestados.size());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}