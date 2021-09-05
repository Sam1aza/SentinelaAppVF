package com.samiaza.sentinela.v3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.samiaza.sentinela.v3.Classes.ApontamentoMedicacao;
import com.samiaza.sentinela.v3.R;

import java.util.List;

public class RecyclerAdapter_MedicacaoEstoque extends RecyclerView.Adapter<RecyclerAdapter_MedicacaoEstoque.ViewHolder> {
    private final List<ApontamentoMedicacao> medApontamentoList;
    private Context context;


    public RecyclerAdapter_MedicacaoEstoque(List<ApontamentoMedicacao> L, Context C) {
        medApontamentoList = L;
        context = C;
    }

    @NonNull
    @Override
    public RecyclerAdapter_MedicacaoEstoque.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new RecyclerAdapter_MedicacaoEstoque.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter_MedicacaoEstoque.ViewHolder holder, int position) {
        ApontamentoMedicacao item = medApontamentoList.get(position);
        //holder.carbamazepina.setText(item.getCarbamazepina());
        //holder.risperidona.setText(item.getRisperidona());
    }

    @Override
    public int getItemCount() {
        return medApontamentoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView carbamazepina;
        protected TextView risperidona;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            carbamazepina = itemView.findViewById(R.id.cb_carbamazepina);
            //risperidona = itemView.findViewById(R.id.txtv_Risperidona);
        }
    }
}
