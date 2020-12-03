package com.samiaza.sentinela.v3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.samiaza.sentinela.v3.Classes.Usuario;
import com.samiaza.sentinela.v3.helper.Medicamento_helper;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class Apontamento<medicamentos, getListamedicao> extends AppCompatActivity {

    private Button btnDarMedicacao;
    private AlertDialog alertDialog;

    private ImageView imageView;


    private Button salvarApontamento;
    private Button tirarFoto;
    private EditText apontInsulina;
    private EditText apontPressao;
    private EditText apontBatimento;
    private EditText obsApontamento;

    private TextView textoUsuario;
    private String UsuarioTextView;

    private TextView dataApont;
    private TextView horaApont;

    private FirebaseDatabase database;
    private FirebaseUser user;
    private DatabaseReference myRef;
    private StorageReference mSorage;

    private String usuarioLog;


    private ProgressDialog mProgress;

    private RadioButton rbtManha;
    private RadioButton rbtTarde;
    private RadioButton rbtNoite;
    private RadioGroup radioGroup;
    private static final int CAMERA_REQUEST_CODE = 1;


    private com.samiaza.sentinela.v3.Classes.Apontamento apontamento;
    private Medicamento_helper medicamentoApont;

    private Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apontamento);
        database = FirebaseDatabase.getInstance();
        mSorage = FirebaseStorage.getInstance().getReference();



        textoUsuario = findViewById(R.id.nome_logado);
        textoUsuario.setText(UsuarioTextView);



        mProgress = new ProgressDialog(this);

        //Instanciando e definindo a hora e data do apontamento
        Calendar calendar = Calendar.getInstance();
        String currentData = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(calendar.getTime());
        String currentHour = DateFormat.getTimeInstance().format(calendar.getTime());



        imageView = findViewById(R.id.img_foto);

        tirarFoto = findViewById(R.id.btn_tirarFoto);
        tirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionarPhoto();
            }
        });

        dataApont = findViewById(R.id.txv_Data);
        horaApont = findViewById(R.id.txv_Hora);
        dataApont.setText(currentData);
        horaApont.setText(currentHour);

        //Instanciando e gravando na base de dados
        apontInsulina = findViewById(R.id.edt_glicose);
        apontPressao = findViewById(R.id.edt_pressao);
        apontBatimento = findViewById(R.id.edt_batimento);
        obsApontamento = findViewById(R.id.edt_obs);

        salvarApontamento = findViewById(R.id.btn_salvarApon);
        salvarApontamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apontInsulina.getText().toString().equals("")) {
                    Snackbar.make(v, "Preencha as informações de glicose", Snackbar.LENGTH_LONG)
                            .setAction("Descartar", null).show();
                } else if (apontPressao.getText().toString().equals("")) {
                    Snackbar.make(v, "Preencha as informações da pressão", Snackbar.LENGTH_LONG)
                            .setAction("Descartar", null).show();
                } else if (apontBatimento.getText().toString().equals("")) {
                    Snackbar.make(v, "Preencha as informações do batimento", Snackbar.LENGTH_LONG)
                            .setAction("Descartar", null).show();
                } else {
                    apontamento = new com.samiaza.sentinela.v3.Classes.Apontamento();
                    apontamento.setDataApontamento(dataApont.getText().toString());
                    apontamento.setHoraApontamento(horaApont.getText().toString());
                    apontamento.setGlicemia(apontInsulina.getText().toString());
                    apontamento.setPressaoArterial(apontBatimento.getText().toString());
                    apontamento.setBatimento(apontPressao.getText().toString());
                    apontamento.setObservacao(obsApontamento.getText().toString());
                    inserirApontamentoDatabase(apontamento);
                }
            }
        });

    }


    private void inserirApontamentoDatabase(com.samiaza.sentinela.v3.Classes.Apontamento apontamento) {
        myRef = database.getReference("Monitoramento");
        String key = myRef.child("apontamento").push().getKey();
        myRef.child(key).setValue(apontamento);
        Toast.makeText(Apontamento.this,
                "Medições e medicações feitas", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Apontamento.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }

    private void inserirApontamentoMedicamentoDatabase(Medicamento_helper medicamentoApont) {
        myRef = database.getReference("Medicação");
        String key = myRef.child("apontamento").push().getKey();
        apontamento.setKeyApontamento(key);
        myRef.child(key).setValue(apontamento);

        Toast.makeText(Apontamento.this,
                "Medições e medicações feitas", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Apontamento.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (uri != null) {
            String filename = "teste";
            final StorageReference ref = FirebaseStorage.getInstance().getReference("/images/" + filename);
            ref.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Log.i("Teste", uri.toString());
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e("teste", e.getMessage(), e);
                }
            });
        }
    }

    private void selecionarPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);

    }

    private void obterUsuario(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            boolean emailVerified = user.isEmailVerified();
            String uid = user.getUid();
            usuarioLog = email;
            UsuarioTextView = name;
        }



        myRef = FirebaseDatabase.getInstance().getReference("Usuarios");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }








}



