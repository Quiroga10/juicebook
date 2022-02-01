package com.quiroga.jugueria;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class JugoCardViewHolder extends RecyclerView.ViewHolder {

    public NetworkImageView jugoImage;
    public TextView jugoTitle;
    public TextView jugoDescription;
    public Button btnVerMas;

    public JugoCardViewHolder(@NonNull View itemView) {
        super(itemView);
        jugoImage = itemView.findViewById(R.id.jugo_image);
        jugoTitle = itemView.findViewById(R.id.jugo_title);
        jugoDescription = itemView.findViewById(R.id.jugo_description);
        btnVerMas = itemView.findViewById(R.id.btnVerMas);
    }

}
