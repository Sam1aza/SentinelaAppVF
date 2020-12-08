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

public class RecyclerAdapter_Pressao extends RecyclerView.Adapter<RecyclerAdapter_Pressao.ViewHolder> {

    private final List<Apontamento> mApontamentoList;
    private Context context;


    public RecyclerAdapter_Pressao(List<Apontamento> L, Context c) {
        mApontamentoList = L;
        context = c;
    }

    public RecyclerAdapter_Pressao(List<Apontamento> list) {
        mApontamentoList = list;
    }


    @NonNull
    @Override
    public RecyclerAdapter_Pressao.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pressao,parent,false);
        return new RecyclerAdapter_Pressao.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter_Pressao.ViewHolder holder, int position) {

        Apontamento item = mApontamentoList.get(position);

        holder.title.setText(item.getPressao());
        holder.title2.setText(item.getBatimento());
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
        protected TextView title2;
        protected TextView descricao;
        protected TextView descricao2;
        protected TextView descricao3;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtv_titleP);
            title2 = itemView.findViewById(R.id.txtv_title2P);
            descricao = itemView.findViewById(R.id.txtv_subtitleP);
            descricao2 = itemView.findViewById(R.id.txtv_subtitle2P);
            descricao3 = itemView.findViewById(R.id.txtv_subtitle3P);
        }
    }
}
