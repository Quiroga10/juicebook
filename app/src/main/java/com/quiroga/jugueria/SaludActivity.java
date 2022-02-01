package com.quiroga.jugueria;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quiroga.jugueria.network.JugoEntry;

public class SaludActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salud_activity);
        onCreateView();
    }

    public void onCreateView () {

        RecyclerView recyclerView = findViewById(R.id.recycler_view1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        JugoCardRecyclerViewAdapter adapter = new JugoCardRecyclerViewAdapter(
                JugoEntry.initJugoEntryList(getResources()));
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.jugo_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.jugo_grid_spacing_small);
        recyclerView.addItemDecoration(new JugoGridItemDecoration(largePadding, smallPadding));

    }
}
