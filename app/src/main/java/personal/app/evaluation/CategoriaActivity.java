package personal.app.evaluation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import personal.app.evaluation.model.Comida;
import personal.app.evaluation.model.Encuestado;

import static personal.app.evaluation.MainActivity.comidas;
import static personal.app.evaluation.MainActivity.encuestados;

public class CategoriaActivity extends AppCompatActivity {

    RadioButton rbCarnes, rbEnsaladas, rbFrutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rbCarnes = (RadioButton)findViewById(R.id.rbCarnes);
        rbEnsaladas = (RadioButton)findViewById(R.id.rbEnsaladas);
        rbFrutas = (RadioButton)findViewById(R.id.rbFrutas);

    }

    public void Validar(View view){
        if (rbCarnes.isChecked()){
            comidas.clear();
            comidas.add(new Comida("Carne 1"));
            comidas.add(new Comida("Carne 2"));
            comidas.add(new Comida("Carne 3"));
            comidas.add(new Comida("Carne 4"));
            comidas.add(new Comida("Carne 5"));
        }
        if (rbEnsaladas.isChecked()){
            comidas.clear();
            comidas.add(new Comida("Ensalada 1"));
            comidas.add(new Comida("Ensalada 2"));
            comidas.add(new Comida("Ensalada 3"));
            comidas.add(new Comida("Ensalada 4"));
            comidas.add(new Comida("Ensalada 5"));
        }
        if (rbFrutas.isChecked()){
            comidas.clear();
            comidas.add(new Comida("Fruta 1"));
            comidas.add(new Comida("Fruta 2"));
            comidas.add(new Comida("Fruta 3"));
            comidas.add(new Comida("Fruta 4"));
            comidas.add(new Comida("Fruta 5"));
        }
        Intent siguiente = new Intent(CategoriaActivity.this, ListaComidaActivity.class);
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