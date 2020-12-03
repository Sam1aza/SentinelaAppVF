package com.samiaza.sentinela.v3.Classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samiaza.sentinela.v3.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    protected ImageView featuredImage;
    protected TextView title;
    protected TextView descricao;
    protected TextView descricao2;
    protected TextView descricao3;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        //featuredImage = itemView.findViewById(R.id.imgv_featured);
        title = itemView.findViewById(R.id.txtv_title);
        descricao = itemView.findViewById(R.id.txtv_subtitle);
        descricao2 = itemView.findViewById(R.id.txtv_subtitle2);
        descricao3 = itemView.findViewById(R.id.txtv_subtitle3);

    }
}
