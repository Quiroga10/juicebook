package com.quiroga.jugueria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GymActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gym_activity);

    }

    public void irLicuadoVerde (View view){
        Intent i = new Intent(getApplicationContext(), LicuadoVerdeActivity.class);
        startActivity(i);
    }
}
