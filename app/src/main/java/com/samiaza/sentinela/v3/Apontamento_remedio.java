package com.samiaza.sentinela.v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samiaza.sentinela.v3.Classes.Apontamento;
import com.samiaza.sentinela.v3.Classes.ApontamentoMedicacao;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.valueOf;

public class Apontamento_remedio extends AppCompatActivity {

    private ApontamentoMedicacao apontamentoMedicacao;

    private Button salvarRemedio;
    private CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;

    private DatabaseReference databaseReference;


    private List<ApontamentoMedicacao> listM = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apontamento_remedio);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        apontamentoMedicacao = new ApontamentoMedicacao();

        listM = new ArrayList<>();

        salvarRemedio = findViewById(R.id.btn_salvarRemed);
        c1 = findViewById(R.id.cb_carbamazepina);
        c2 = findViewById(R.id.cb_risperidona);
        c3 = findViewById(R.id.cb_Brilinta);
        c4 = findViewById(R.id.cb_Losartana);
        c5 = findViewById(R.id.cb_Concor);
        c6 = findViewById(R.id.cb_Zimpas);
        c7 = findViewById(R.id.cb_Lasix);
        c8 = findViewById(R.id.cb_AAS);
        c9 = findViewById(R.id.cb_Aldactone);
        c10 = findViewById(R.id.cb_Ancorom);



        salvarRemedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c1.isChecked()){
                    apontarCarbama();
                }else{

                }if(c2.isChecked()){
                    apontarRisp();
                }else{

                }if(c3.isChecked()){
                    apontarBrili();
                }else{

                }if(c4.isChecked()){
                    apontarLosart();
                }else{

                }if(c5.isChecked()){
                    apontarConcor();
                }else{

                }if(c6.isChecked()){
                    apontarZimpass();
                }else{

                }if(c7.isChecked()){
                    apontarLasix();
                }else{

                }if(c8.isChecked()){
                    apontarAss();
                }else{

                }if(c9.isChecked()){
                    apontarAldac();
                }else{

                }if(c10.isChecked()){
                    apontarAncor();
                }else{

                }
            }
        });




    }

    private void apontarCarbama(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getCarbamazepina()));
                int b = a - 1;
                apontamentoMedicacao.setCarbamazepina(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarRisp(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getRisperidona()));
                int b = a - 1;
                apontamentoMedicacao.setRisperidona(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarBrili(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getBrilinta()));
                int b = a - 1;
                apontamentoMedicacao.setBrilinta(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarLosart(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getLosartana()));
                int b = a - 1;
                apontamentoMedicacao.setLosartana(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarConcor(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getConcor()));
                int b = a - 1;
                apontamentoMedicacao.setConcor(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarZimpass(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getZimpass()));
                int b = a - 1;
                apontamentoMedicacao.setZimpass(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarLasix(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getLasix()));
                int b = a - 1;
                apontamentoMedicacao.setLasix(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarAss(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getAas()));
                int b = a - 1;
                apontamentoMedicacao.setAas(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarAldac(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getAldactone()));
                int b = a - 1;
                apontamentoMedicacao.setAldactone(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }
    private void apontarAncor(){
        ValueEventListener valueEventListener;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM.add(apontamentoMedicacao);
                int a  = Integer.parseInt(String.valueOf(apontamentoMedicacao.getAnccorom()));
                int b = a - 1;
                apontamentoMedicacao.setAnccorom(b);
                databaseReference.child("medicamentos").setValue(apontamentoMedicacao);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        Intent intent = new Intent(Apontamento_remedio.this, Pag_inicial.class);
        startActivity(intent);
        finish();
    }



}
