package com.example.robotandroid.TacheRepository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.OperationRepository.Operation;
import com.example.robotandroid.R;

import java.util.List;

public class TacheAdapter extends RecyclerView.Adapter<TacheViewHolder>  {

 List<Tache> listTaches;
 private Gamme gamme;
 private Operation operation;


    public TacheAdapter(Gamme gamme, Operation operation) {
        this.listTaches = operation.getListeTaches();
        this.operation = operation;
        this.gamme = gamme;
    }

    //Liste entière des items Operation

    public TacheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.widget_liste_tache,parent,false);
        return new TacheViewHolder(view);
    }

    public void onBindViewHolder(TacheViewHolder holder, int position) {
        // on charge l'item graphique, on dit ce qu'il faut afficher dans l'item.
        holder.UpdateVisual(listTaches.get(position),operation, gamme);
    }

    public int getItemCount() {
        return listTaches.size();
    }

}
