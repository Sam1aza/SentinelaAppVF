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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.samiaza.sentinela.v3.Classes.Usuario;



public class Cadastrar extends AppCompatActivity {

    private EditText nomeCadastro;
    private EditText emailCadastro;
    private EditText senhaCadastro;
    private EditText reSenhaCadastro;
    private Button realizarCadastro;

    private Usuario usuario;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();


        usuario = new Usuario();

        nomeCadastro = findViewById(R.id.edt_nomec);
        emailCadastro = findViewById(R.id.edt_emailc);
        senhaCadastro = findViewById(R.id.edt_passwdc);
        reSenhaCadastro = findViewById(R.id.edt_reppasswc);

        realizarCadastro = findViewById(R.id.btn_realizarcadastro);
        realizarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (senhaCadastro.getText().toString().equals(reSenhaCadastro.getText().toString())) {
                    usuario.setEmail(emailCadastro.getText().toString());
                    usuario.setNome(nomeCadastro.getText().toString());
                    usuario.setSenha(senhaCadastro.getText().toString());
                    cadastrarUsuario(emailCadastro.getText().toString(), senhaCadastro.getText().toString());

                }

            }
        });


    }

    private void cadastrarUsuario(String email, String senha) {

        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Cadastrar.this,
                                    "Conta criada com sucesso!", Toast.LENGTH_LONG).show();
                            inserirUsuarioDatabase(usuario);
                            abrirPagInicial();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Cadastrar.this,
                                    "Erro de cadastro de usuario",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


    private void inserirUsuarioDatabase(Usuario usuario) {
        myRef = database.getReference("Usuarios");
        String key = myRef.child("Usuarios").push().getKey();
        usuario.setKeyUser(key);
        myRef.child(key).setValue(usuario);
    }

    private void abrirPagInicial() {
        Intent intent = new Intent(this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }




}
