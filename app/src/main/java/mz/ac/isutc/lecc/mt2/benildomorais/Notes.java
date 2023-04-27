package mz.ac.isutc.lecc.mt2.benildomorais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import mz.ac.isutc.lecc.mt2.benildomorais.databinding.ActivityIntentsGatewayBinding;
import mz.ac.isutc.lecc.mt2.benildomorais.databinding.ActivityNotesBinding;

public class Notes extends AppCompatActivity {

    private ArrayList lista;
    private ActivityNotesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        lista = new ArrayList<Notas>();

        binding.listarNotasActivas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lista.size() == 0) {
                    Toast.makeText(Notes.this, "A Lista está vasia Grave alguma coisa", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Notes.this, NotasList.class);
                    intent.putParcelableArrayListExtra("keylista", lista);
                    startActivity(intent);
                }
            }
        });

        binding.gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gravar();
            }
        });

    }


    private void gravar(){
        String titulo = binding.titulo.getText().toString();
        String descricao = binding.descricao.getText().toString();
        String estado = binding.ativo.getText().toString();
        String data = binding.data.getText().toString();

        Notas controle = new Notas(titulo, descricao, estado, data);

        if (estado.equalsIgnoreCase("sim")) {
            Toast.makeText(this, "Está Activo", Toast.LENGTH_SHORT).show();
            lista.add(controle);
        }


        Toast.makeText(this, "Gravado", Toast.LENGTH_SHORT).show();
    }
}