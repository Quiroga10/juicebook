package com.quiroga.jugueria;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quiroga.jugueria.network.ImageRequester;
import com.quiroga.jugueria.network.JugoEntry;

import java.util.List;

public class JugoCardRecyclerViewAdapter extends RecyclerView.Adapter<JugoCardViewHolder> {

    private List<JugoEntry> jugoList;
    private ImageRequester imageRequester;

    JugoCardRecyclerViewAdapter(List<JugoEntry> jugoList) {
        this.jugoList = jugoList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public JugoCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.jugo_card, parent, false);
        return new JugoCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull JugoCardViewHolder holder, int position) {

        JugoEntry jugo = jugoList.get(position);
        holder.jugoTitle.setText(jugo.title);
        holder.jugoDescription.setText(jugo.description);
        imageRequester.setImageFromUrl(holder.jugoImage, jugo.url);

        holder.btnVerMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.itemView.getContext(), LicuadoActivity.class);
                i.putExtra("jugo", jugo);
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jugoList.size();
    }
}
