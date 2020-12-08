package com.samiaza.sentinela.v3.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samiaza.sentinela.v3.Classes.Apontamento;
import com.samiaza.sentinela.v3.R;

import java.util.List;

public class RecyclerAdapter_Glicose extends RecyclerView.Adapter<RecyclerAdapter_Glicose.ViewHolder> {

    private final List<com.samiaza.sentinela.v3.Classes.Apontamento> mApontamentoList;
    private Context context;


    public RecyclerAdapter_Glicose(List<Apontamento> L, Context c) {
        mApontamentoList = L;
        context = c;
    }

    public RecyclerAdapter_Glicose(List<Apontamento> list) {
        mApontamentoList = list;
    }


    @NonNull
    @Override
    public RecyclerAdapter_Glicose.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new RecyclerAdapter_Glicose.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter_Glicose.ViewHolder holder, int position) {
        Apontamento item = mApontamentoList.get(position);
        holder.title.setText(item.getGlicose());
        holder.descricao.setText(item.getData());
        holder.descricao2.setText(item.getHora());
        holder.descricao3.setText(item.getObservacao());
    }

    @Override
    public int getItemCount() {
        return mApontamentoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        protected TextView title;
        protected TextView descricao;
        protected TextView descricao2;
        protected TextView descricao3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtv_title);
            descricao = itemView.findViewById(R.id.txtv_subtitle);
            descricao2 = itemView.findViewById(R.id.txtv_subtitle2);
            descricao3 = itemView.findViewById(R.id.txtv_subtitle3);
        }
    }
}
