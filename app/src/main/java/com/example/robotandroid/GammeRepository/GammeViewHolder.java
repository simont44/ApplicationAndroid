package com.example.robotandroid.GammeRepository;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.robotandroid.GammeRepository.Gamme;
import com.example.robotandroid.R;

public class GammeViewHolder extends RecyclerView.ViewHolder {

    Context context;
    private Gamme unegamme;

    public GammeViewHolder(View itemView) {
        super(itemView);

    }

    public Gamme getUnegamme() {
        return unegamme;
    }

    public void setUnegamme(Gamme unegamme) {
        this.unegamme = unegamme;
    }

    public void UpdateVisual(Gamme unegamme)
    {
        this.unegamme = unegamme;
        TextView TV = context.findViewById(R.id.TextViewLabelGamme);
        //Mettre à jour le visuel
    }

}
