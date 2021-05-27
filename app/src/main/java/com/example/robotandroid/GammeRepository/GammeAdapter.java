package com.example.robotandroid.GammeRepository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.R;

import java.util.List;

public class GammeAdapter extends RecyclerView.Adapter<GammeViewHolder> {

    List<Gamme> ListGamme ;

    public GammeAdapter(List<Gamme> listGamme) {
        ListGamme = listGamme;
    }

    //Liste entière des items Gammes
    @Override
    public GammeViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.widget_liste_gamme,parent,false);
        return new GammeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GammeViewHolder holder, int position) {
    // on charge l'item graphic, on dit ce qu'il faut afficher dans l'item.
        holder.UpdateVisual(ListGamme.get(position));
    }

    @Override
    public int getItemCount() {
        return ListGamme.size();
    }

}
