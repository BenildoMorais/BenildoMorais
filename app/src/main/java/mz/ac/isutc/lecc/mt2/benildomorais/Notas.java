package mz.ac.isutc.lecc.mt2.benildomorais;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Notas implements Parcelable {

    private String titulo;
    private String descrição;
    private Boolean estado;
    private String data;

    public Notas(String titulo, String descrição, Boolean estado, String data){
        this.titulo = titulo;
        this.descrição = descrição;
        this.estado = estado;
        this.data = data;
    }

    protected Notas(Parcel in) {
        titulo = in.readString();
        descrição = in.readString();
        byte tmpEstado = in.readByte();
        estado = tmpEstado == 0 ? null : tmpEstado == 1;
        data = in.readString();
    }

    public static final Creator<Notas> CREATOR = new Creator<Notas>() {
        @Override
        public Notas createFromParcel(Parcel in) {
            return new Notas(in);
        }

        @Override
        public Notas[] newArray(int size) {
            return new Notas[size];
        }
    };

    public String getData() {
        return data;
    }

    public String getDescrição() {
        return descrição;
    }

    public Boolean getEstado() {
        return estado;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(descrição);
        parcel.writeByte((byte) (estado == null ? 0 : estado ? 1 : 2));
        parcel.writeString(data);
    }

    @NonNull
    @Override
    public String toString() {
        return this.titulo;
    }
}
