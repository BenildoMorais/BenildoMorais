package mz.ac.isutc.lecc.mt2.benildomorais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import mz.ac.isutc.lecc.mt2.benildomorais.databinding.ActivityIntentsGatewayBinding;

public class IntentsGateway extends AppCompatActivity {

    private ActivityIntentsGatewayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntentsGatewayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                website();
            }
        });

        binding.ligacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ligacao();
            }

        });

        binding.camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });

        binding.maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4= new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse("geo:0,0?q=my+location"));
                startActivity(i4);
            }
        });

    }

    private void ligacao() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:874585098"));
        startActivity(intent);
    }

    public void website(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.isutc.ac.mz"));
        startActivity(intent);
    }

}