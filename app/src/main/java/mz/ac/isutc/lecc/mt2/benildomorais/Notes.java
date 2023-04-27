package mz.ac.isutc.lecc.mt2.benildomorais;

import androidx.annotation.Nullable;
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
                    startActivityForResult(intent, 1);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            try {
            lista = data.getParcelableArrayListExtra("keyArray");
            }catch (NullPointerException e){
                lista = this.lista;
            }
        }
    }

    private void gravar(){

        if (binding.naoAtivo.isChecked()) {
            Toast.makeText(this, "Nao foi gravado poois nao está ativo", Toast.LENGTH_SHORT).show();
        }else {

            String titulo = binding.titulo.getText().toString();
            String descricao = binding.descricao.getText().toString();
            Boolean estado = binding.ativo.isChecked();
            String data = binding.data.getText().toString();

            if (titulo.equalsIgnoreCase("") || titulo == null || descricao.equalsIgnoreCase("") || data.equalsIgnoreCase("")) {
                Toast.makeText(this, "Preencha Todos os campos", Toast.LENGTH_SHORT).show();
            }else {
                Notas controle = new Notas(titulo, descricao, estado, data);

                lista.add(controle);

                Toast.makeText(this, "Gravado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}