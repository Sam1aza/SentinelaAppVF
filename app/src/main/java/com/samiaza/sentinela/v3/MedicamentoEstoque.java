package com.samiaza.sentinela.v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samiaza.sentinela.v3.Adapter.RecyclerAdapter_Glicose;
import com.samiaza.sentinela.v3.Classes.ApontamentoMedicacao;

import java.util.ArrayList;
import java.util.List;

public class MedicamentoEstoque extends AppCompatActivity {

    private TextView EstoqueCarba,EstoqueRisp,EstoqueBri,EstoqueLosa,EstoqueConcor,EstoqueZimp,EstoqueLasix,EstoqueAAS,EstoqueAldac,EstoqueAnc;


    private ApontamentoMedicacao apontamentoMedicacao;
    private List<ApontamentoMedicacao> listM2 = new ArrayList<>();

    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos_estoque);



        databaseReference = FirebaseDatabase.getInstance().getReference();
        apontamentoMedicacao = new ApontamentoMedicacao();

        listM2 = new ArrayList<>();

        EstoqueCarba = findViewById(R.id.cb_carbamazepina);
        EstoqueRisp = findViewById(R.id.cb_risperidona);
        EstoqueBri = findViewById(R.id.cb_Brilinta);
        EstoqueLosa = findViewById(R.id.cb_Losartana);
        EstoqueConcor = findViewById(R.id.cb_Concor);
        EstoqueZimp = findViewById(R.id.cb_Zimpas);
        EstoqueLasix = findViewById(R.id.cb_Lasix);
        EstoqueAAS = findViewById(R.id.cb_AAS);
        EstoqueAldac = findViewById(R.id.cb_Aldactone);
        EstoqueAnc = findViewById(R.id.cb_Ancorom);

        ValueEventListener valueEventListener3;
        databaseReference.child("medicamentos").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ApontamentoMedicacao apontamentoMedicacao = dataSnapshot.getValue(ApontamentoMedicacao.class);
                listM2.add(apontamentoMedicacao);
                //Log.i("Listainicial", String.valueOf(apontamentoMedicacao.getZimpass()));

                EstoqueCarba.setText(String.valueOf(apontamentoMedicacao.getCarbamazepina()));
                EstoqueRisp.setText(String.valueOf(apontamentoMedicacao.getRisperidona()));
                EstoqueBri.setText(String.valueOf(apontamentoMedicacao.getBrilinta()));
                EstoqueLosa.setText(String.valueOf(apontamentoMedicacao.getLosartana()));
                EstoqueConcor.setText(String.valueOf(apontamentoMedicacao.getConcor()));
                EstoqueZimp.setText(String.valueOf(apontamentoMedicacao.getZimpass()));
                EstoqueLasix.setText(String.valueOf(apontamentoMedicacao.getLasix()));
                EstoqueAAS.setText(String.valueOf(apontamentoMedicacao.getAas()));
                EstoqueAldac.setText(String.valueOf(apontamentoMedicacao.getAldactone()));
                EstoqueAnc.setText(String.valueOf(apontamentoMedicacao.getAnccorom()));

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


    }

}