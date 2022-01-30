package com.quiroga.jugueria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrarActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText correo;
    private EditText contrasena;
    private EditText contrasenaConfirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_activity);

        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);
        contrasenaConfirmacion = findViewById(R.id.contrasenaConfirmacion);

    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void registrarUsuario(View view) {

        if(contrasena.getText().toString().equals(contrasenaConfirmacion.getText().toString())){

            mAuth.createUserWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(), "Usuario creado correctamente.",Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();


                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(i);


                            }else {

                                Toast.makeText(getApplicationContext(), "Authentication failed.",Toast.LENGTH_SHORT).show();


                            }
                        }
                    });

        }else {
            Toast.makeText(this, "Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
        }

    }

}
