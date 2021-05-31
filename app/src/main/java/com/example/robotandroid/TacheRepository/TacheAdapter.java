package com.example.robotandroid.TacheRepository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.R;

import java.util.List;

public class TacheAdapter extends RecyclerView.Adapter<TacheViewHolder>  {

 List<Tache> listTaches;

    public TacheAdapter(List<Tache> listTaches) {
        this.listTaches = listTaches;
    }

    //Liste entière des items Operation

    public TacheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.widget_liste_tache,parent,false);
        return new TacheViewHolder(view);
    }

    public void onBindViewHolder(TacheViewHolder holder, int position) {
        // on charge l'item graphic, on dit ce qu'il faut afficher dans l'item.
        holder.UpdateVisual(listTaches.get(position));
    }

    public int getItemCount() {
        return listTaches.size();
    }

}
