package mz.ac.isutc.lecc.mt2.benildomorais;

/*public class controle {

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import mz.ac.isutc.lecc31.intentaplication.databinding.ActivityMainBinding;

    public class MainActivity extends AppCompatActivity {
        private ActivityMainBinding mainBinding;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(mainBinding.getRoot());

            mainBinding.site.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Url = "https://www.isutc.ac.mz";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(Url));
                    startActivity(i);
                }
            });

            mainBinding.Ligacao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String number = "tel:843671529";
                    Intent i2 = new Intent(Intent.ACTION_CALL);
                    i2.setData(Uri.parse(number));
                    startActivity(i2);
                }
            });

            mainBinding.camera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i3= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i3,1);
                }
            });

            mainBinding.Maps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i4= new Intent(Intent.ACTION_VIEW);
                    i4.setData(Uri.parse("geo:0,0?q=my+location"));
                    startActivity(i4);
                }
            });
        }
    }
}
*/