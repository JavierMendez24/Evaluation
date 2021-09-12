package personal.app.evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import personal.app.evaluation.model.Comida;
import personal.app.evaluation.model.Encuestado;

public class MainActivity extends AppCompatActivity {

    Button btnEncuesta, btnVerLista, btnDatos;

    public static ArrayList<Encuestado> encuestados = new ArrayList<>();
    public static Encuestado objetoEncuestado = new Encuestado();
    public static ArrayList<Comida> comidas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEncuesta = (Button)findViewById(R.id.btnAgregar);
        btnVerLista = (Button)findViewById(R.id.btnVerLista);
        btnDatos = (Button)findViewById(R.id.btnDatos);

        btnEncuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent encuesta = new Intent(MainActivity.this, EncuestaActivity.class);
                startActivity(encuesta);
            }
        });

        btnVerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (encuestados.isEmpty()){
                    Toast.makeText(MainActivity.this, "Lista vacia", Toast.LENGTH_SHORT).show();
                }else {
                    Intent encuestados = new Intent(MainActivity.this, ListaEncuestadosActivity.class);
                    startActivity(encuestados);
                }
            }
        });

        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent datos = new Intent(MainActivity.this, DatosActivity.class);
                startActivity(datos);
            }
        });
    }

}