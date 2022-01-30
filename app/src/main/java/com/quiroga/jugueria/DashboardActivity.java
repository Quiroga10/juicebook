package com.quiroga.jugueria;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

    }

    public void irSalud(View view) {
        Intent i = new Intent(getApplicationContext(), SaludActivity.class);
        startActivity(i);
    }

    public void irJugosCasa(View view){
        Intent i = new Intent(getApplicationContext(), JugosCasaActivity.class);
        startActivity(i);
    }

    public void irGym(View view) {
        Intent i = new Intent(getApplicationContext(), GymActivity.class);
        startActivity(i);
    }

    public void irEstractos(View view) {
        Intent i = new Intent(getApplicationContext(), EstractosActivity.class);
        startActivity(i);
    }

    public void irVideos(View view) {
        Intent i = new Intent(getApplicationContext(), VideosActivity.class);
        startActivity(i);
    }

    public void irVerTodos(View view){

    }




    //Se va a controlar la pulsación del boton atras
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Deseas salir de la aplicación?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
