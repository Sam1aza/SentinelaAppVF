package com.samiaza.sentinela.v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.samiaza.sentinela.v3.Classes.ApontamentoMedicacao;

public class Apontamento_remedio extends AppCompatActivity {

    private ApontamentoMedicacao apontamentoMedicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apontamento_remedio);
    }
}
