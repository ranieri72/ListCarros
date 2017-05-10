package com.ranieri.exercicio2;

import android.os.Parcel;
import android.os.Parcelable;

public class Carros implements Parcelable {

    private String modelo;
    private int fabricante;
    private int ano;

    public Carros(String modelo, int fabricante, int ano) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
    }

    protected Carros(Parcel in) {
        modelo = in.readString();
        fabricante = in.readInt();
        ano = in.readInt();
    }

    public static final Creator<Carros> CREATOR = new Creator<Carros>() {
        @Override
        public Carros createFromParcel(Parcel in) {
            return new Carros(in);
        }

        @Override
        public Carros[] newArray(int size) {
            return new Carros[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(modelo);
        dest.writeInt(fabricante);
        dest.writeInt(ano);
    }

    @Override
    public String toString() {
        return modelo + " - " + fabricante + " - " + ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getFabricante() {
        return fabricante;
    }

    public void setFabricante(int fabricante) {
        this.fabricante = fabricante;
    }
}
