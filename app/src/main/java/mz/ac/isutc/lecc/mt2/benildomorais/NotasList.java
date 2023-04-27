package mz.ac.isutc.lecc.mt2.benildomorais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import mz.ac.isutc.lecc.mt2.benildomorais.databinding.ActivityNotasListBinding;

public class NotasList extends AppCompatActivity {

    private ArrayList lista;
    private ActivityNotasListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotasListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        lista = getIntent().getParcelableArrayListExtra("keylista");


        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,lista);
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

     binding.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
         @Override
         public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
             lista.remove(i);

             Intent resultIntent = new Intent();
             resultIntent.putExtra("keyArray",lista);
             setResult(RESULT_OK,resultIntent);
             finish();
             return false;
         }
     });
    }
}