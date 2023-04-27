package mz.ac.isutc.lecc.mt2.benildomorais;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import mz.ac.isutc.lecc.mt2.benildomorais.databinding.ActivityDetalhesNotaBinding;

public class DetalhesNota extends AppCompatActivity {

    private ActivityDetalhesNotaBinding binding;
    private Notas notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalhesNotaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notas = getIntent().getParcelableExtra("keyNota");

        binding.tiulo.setText(notas.getTitulo());

        binding.descricao.setText("Descrição: "+notas.getDescrição());

        binding.estado.setText("Activação: "+notas.getEstado().toString());

        binding.data.setText("Data: "+notas.getData());
    }
}