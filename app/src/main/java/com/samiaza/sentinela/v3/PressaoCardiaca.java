package com.samiaza.sentinela.v3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.samiaza.sentinela.v3.Adapter.RecyclerAdapter_Glicose;
import com.samiaza.sentinela.v3.Adapter.RecyclerAdapter_Pressao;
import com.samiaza.sentinela.v3.Classes.Apontamento;

import java.util.ArrayList;
import java.util.List;

public class PressaoCardiaca extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerAdapter_Pressao adapter;
    private List<Apontamento> list = new ArrayList<>();
    private DatabaseReference databaseReference;
    private Apontamento apontamento;
    private LinearLayoutManager mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressao_cardiaca);

        recyclerView = findViewById(R.id.rcy_pressao);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerAdapter_Pressao(list);
        recyclerView.setAdapter(adapter);
        popularListaInjetaveis();


    }

    private void popularListaInjetaveis(){
        recyclerView.setHasFixedSize(true);
        /*mLinearLayout = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);*/
        list = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        ValueEventListener valueEventListener = databaseReference
                .child("apontamentos").limitToLast(50)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list.clear();
                        for (DataSnapshot apontamentosSnapshot : dataSnapshot.getChildren()) {
                            apontamento = apontamentosSnapshot.getValue(Apontamento.class);
                            list.add(apontamento);
                        }
                        java.util.Collections.reverse(list);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

        adapter = new RecyclerAdapter_Pressao(list,getBaseContext());
        recyclerView.setAdapter(adapter);


    }
}
