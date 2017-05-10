package com.ranieri.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaCarrosActivity extends AppCompatActivity {

    ListView mListView;
    static List<Carros> mCarros;
    CarroAdapter mAdapter;

    View.OnClickListener tratadorDeEventos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent it = new Intent(ListaCarrosActivity.this, CadastroActivity.class);
            startActivityForResult(it, 0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carros);

        mListView = (ListView) findViewById(R.id.listCarros);
        if (mCarros == null){
            mCarros = new ArrayList<Carros>();
        }
        mAdapter = new CarroAdapter(this, mCarros);
        mListView.setAdapter(mAdapter);


        findViewById(R.id.btnNovo).setOnClickListener(tratadorDeEventos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK){
            Carros carro = data.getParcelableExtra("carro");
            mCarros.add(carro);
            mAdapter.notifyDataSetChanged();
        }
    }
}
