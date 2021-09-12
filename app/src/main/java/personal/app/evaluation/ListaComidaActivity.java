package personal.app.evaluation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import personal.app.evaluation.model.Comida;
import personal.app.evaluation.model.Encuestado;

import static personal.app.evaluation.MainActivity.comidas;
import static personal.app.evaluation.MainActivity.encuestados;
import static personal.app.evaluation.MainActivity.objetoEncuestado;

public class ListaComidaActivity extends AppCompatActivity {

    ListView lsvComida;
    Button btnFinalizar;
    String seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comida);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        lsvComida = (ListView)findViewById(R.id.lsvComida);
        btnFinalizar = (Button)findViewById(R.id.btnFinalizar);

        ArrayAdapter<Comida> adapterComida = new ArrayAdapter(this, android.R.layout.simple_list_item_1, comidas);

        lsvComida.setAdapter(adapterComida);

        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Importante");
        dialogo1.setMessage("¿ Quiere aceptar ?");
        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                aceptar();
            }
        });
        dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                cancelar();
            }
        });

        lsvComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Comida c = comidas.get(position);
                dialogo1.show();
                seleccion = c.getNombre();
            }
        });

    }

    public void aceptar() {
        Toast t=Toast.makeText(this,"Comida seleccionada", Toast.LENGTH_SHORT);
        t.show();
    }

    public void cancelar() {
        finish();
    }

    public void Finalizar(View view){
        objetoEncuestado.setComida(seleccion);
        encuestados.add(objetoEncuestado);
        Intent siguiente = new Intent(ListaComidaActivity.this, MainActivity.class);
        startActivity(siguiente);
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