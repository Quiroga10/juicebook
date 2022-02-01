package com.quiroga.jugueria;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.NetworkImageView;
import com.quiroga.jugueria.network.ImageRequester;
import com.quiroga.jugueria.network.JugoEntry;

public class LicuadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.licuadoverde_activity);
        JugoEntry jugo = getIntent().getExtras().getParcelable("jugo");
        TextView textView = (TextView) findViewById(R.id.txtLicuado);
        NetworkImageView network = findViewById(R.id.imageView);
        textView.setText(jugo.title);
        ImageRequester.getInstance().setImageFromUrl(network, jugo.url);
    }
}
