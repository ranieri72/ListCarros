package com.ranieri.exercicio2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarroAdapter extends ArrayAdapter<Carros> {

    public CarroAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //1)
        Carros carro = getItem(position);

        //2)
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_carro, null);
        }

        //3)
        ImageView imgLogo = (ImageView)convertView.findViewById(R.id.imgLogo);
        TextView txtModelo = (TextView)convertView.findViewById(R.id.txtModelo2);
        TextView txtAno = (TextView)convertView.findViewById(R.id.txtAno2);

        imgLogo.setImageResource(getIcone(carro.getFabricante()));
        txtModelo.setText(carro.getModelo());
        txtAno.setText(String.valueOf(carro.getAno()));

        //4)
        return convertView;
    }

    private int getIcone(int fabricante){
        switch (fabricante){
            case dicionario.vw : return R.drawable.vw;
            case dicionario.gm : return R.drawable.gm;
            case dicionario.fiat : return R.drawable.fiat;
            default: return R.drawable.ford;
        }
    }
}
