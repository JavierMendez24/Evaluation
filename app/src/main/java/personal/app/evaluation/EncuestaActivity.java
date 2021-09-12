package personal.app.evaluation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import personal.app.evaluation.model.Encuestado;

import static personal.app.evaluation.MainActivity.objetoEncuestado;

public class EncuestaActivity extends AppCompatActivity {

    Button btnSiguienteEncuesta;
    EditText edtNombre, edtEdad;
    RadioButton rbMasculino, rbFemenino, rbOtro;
    Intent siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnSiguienteEncuesta = (Button)findViewById(R.id.btnSiguienteEncuesta);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtEdad = (EditText) findViewById(R.id.edtEdad);
        rbMasculino = (RadioButton)findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton)findViewById(R.id.rbFemenino);
        rbOtro = (RadioButton)findViewById(R.id.rbOtro);

        objetoEncuestado = new Encuestado();

    }

    public void SiguienteEncuesta(View view){

        if (edtNombre.getText().toString().isEmpty() || edtEdad.getText().toString().isEmpty()){
            Toast t=Toast.makeText(this,"Faltan campos a llenar", Toast.LENGTH_SHORT);
            t.show();
        }else {
            objetoEncuestado.setNombre(edtNombre.getText().toString());
            objetoEncuestado.setEdad(edtEdad.getText().toString());

            siguiente = new Intent(EncuestaActivity.this, CategoriaActivity.class);
            startActivity(siguiente);
        }


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