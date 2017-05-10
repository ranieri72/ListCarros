package com.ranieri.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class CadastroActivity extends AppCompatActivity {

    EditText mEdtModelo;
    Spinner mSpnFabricante;
    EditText mEdtAno;

    View.OnClickListener tratadorDeEvento = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String modelo = mEdtModelo.getText().toString();
            int ano = Integer.parseInt(mEdtAno.getText().toString());
            int fabricante = mSpnFabricante.getSelectedItemPosition();

            Carros carro = new Carros(modelo, fabricante, ano);

            Intent it = new Intent();
            it.putExtra("carro", carro);
            setResult(RESULT_OK, it);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mEdtModelo = (EditText) findViewById(R.id.txtModelo);
        mEdtAno = (EditText)findViewById(R.id.txtAno);
        mSpnFabricante = (Spinner)findViewById(R.id.spnFabricantes);

        findViewById(R.id.btnSalvar).setOnClickListener(tratadorDeEvento);
    }
}
