package mz.ac.isutc.lecc.mt2.benildomorais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import mz.ac.isutc.lecc.mt2.benildomorais.databinding.ActivityIntentsGatewayBinding;

public class IntentsGateway extends AppCompatActivity {

    private ActivityIntentsGatewayBinding binding;

    private Spinner spiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntentsGatewayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.spiner = binding.spinner;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Gateway, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(adapter);

        binding.ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = binding.spinner.getSelectedItemPosition();

                if (i == 0) {
                    website();
                }else if (i == 1) {
                    ligacao();
                }else if (i == 2) {
                    maps();
                }else if (i == 3) {
                    camera();
                }
            }
        });

    }

    private void maps() {
        Intent i4= new Intent(Intent.ACTION_VIEW);
        i4.setData(Uri.parse("geo:0,0?q=my+location"));
        startActivity(i4);
    }

    private void camera() {
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,1);
    }

    private void ligacao() {

        int numero =-1;

        if (binding.texto.getText().toString().equalsIgnoreCase("") == false){
            numero =  Integer.parseInt(binding.texto.getText().toString());
            Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse("tel:"+numero));
            startActivity(intent);
        }else{
            aletra();
        }

    }

    private void aletra() {
        Toast.makeText(this, "Campo vasio", Toast.LENGTH_SHORT).show();
    }

    private void website(){

        String site;

        if (binding.texto.getText().toString().equalsIgnoreCase("") == false) {
            site = binding.texto.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://"+site));
            startActivity(intent);
        }else{
        aletra();
    }

    }

}