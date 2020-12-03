package com.samiaza.sentinela.v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText emailLogin;
    private EditText passwLogin;

    private Button criarCadastro;
    private Button logar;

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();


        emailLogin = findViewById(R.id.edt_email);
        passwLogin = findViewById(R.id.edt_passwd);


        criarCadastro = findViewById(R.id.btn_realcadastro);
        criarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCadastro();
            }
        });

        logar = findViewById(R.id.btn_login);
        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailLogin.getText().toString().equals("")
                        && passwLogin.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Preencha os campos de e-mail e senha", Toast.LENGTH_LONG).show();
                } else if (emailLogin.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Preencha os campos de e-mail", Toast.LENGTH_LONG).show();
                } else if (passwLogin.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,
                            "Preencha os campos de senha", Toast.LENGTH_LONG).show();
                } else {
                    abrirLogin(emailLogin.getText().toString(), passwLogin.getText().toString());

                }
            }
        });


    }

    private void abrirCadastro() {
        Intent intent = new Intent(MainActivity.this, Cadastrar.class);
        startActivity(intent);
    }

    private void abrirLogin(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            Toast.makeText(MainActivity.this, "Login efetuado com sucesso!",
                                    Toast.LENGTH_LONG).show();
                            abrirPrincipal();
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Erro de autenticação.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });

    }

    private void abrirPrincipal() {
        Intent intent = new Intent(MainActivity.this, Pag_inicial.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            abrirPrincipal();
            finish();
        }
    }


}
